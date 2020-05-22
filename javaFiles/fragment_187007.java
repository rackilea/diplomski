package opencv.test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.Scalar;
import org.opencv.features2d.DMatch;
import org.opencv.features2d.DescriptorExtractor;
import org.opencv.features2d.DescriptorMatcher;
import org.opencv.features2d.FeatureDetector;
import org.opencv.features2d.Features2d;
import org.opencv.highgui.Highgui;

public class MatchDetection {

    public static BufferedImage detectMatches(File file, File file2) {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat img_1 = Highgui.imread(file.getAbsolutePath(), Highgui.CV_LOAD_IMAGE_GRAYSCALE);
        Mat img_2 = Highgui.imread(file2.getAbsolutePath(), Highgui.CV_LOAD_IMAGE_GRAYSCALE);

        if (img_1.empty() || img_2.empty()) {
            System.out.println(" --(!) Error reading images ");
            return null;
        }

        // -- Step 1: Detect the keypoints using SURF Detector
        //I am not sure where to use it
        int minHessian = 400;

        FeatureDetector detector = FeatureDetector.create(FeatureDetector.SURF);

        MatOfKeyPoint keypoints_1 = new MatOfKeyPoint();
        MatOfKeyPoint keypoints_2 = new MatOfKeyPoint();

        detector.detect(img_1, keypoints_1);
        detector.detect(img_2, keypoints_2);

        // -- Step 2: Calculate descriptors (feature vectors)
        DescriptorExtractor extractor = DescriptorExtractor
                .create(DescriptorExtractor.SURF);

        Mat descriptors_1 = new Mat();
        Mat descriptors_2 = new Mat();

        extractor.compute(img_1, keypoints_1, descriptors_1);
        extractor.compute(img_2, keypoints_2, descriptors_2);

        // -- Step 3: Matching descriptor vectors using FLANN matcher
        DescriptorMatcher matcher = DescriptorMatcher
                .create(DescriptorExtractor.SURF);
        MatOfDMatch matches = new MatOfDMatch();
        matcher.match(descriptors_1, descriptors_2, matches);
        DMatch[] matchesArr = matches.toArray();

        double max_dist = 0;
        double min_dist = 100;

        // -- Quick calculation of max and min distances between keypoints
        for (int i = 0; i < matchesArr.length; i++) {
            double dist = matchesArr[i].distance;
            if (dist < min_dist)
                min_dist = dist;
            if (dist > max_dist)
                max_dist = dist;
        }

        System.out.printf("-- Max dist : %f \n", max_dist);
        System.out.printf("-- Min dist : %f \n", min_dist);

        // -- Draw only "good" matches (i.e. whose distance is less than
        // 2*min_dist,
        // -- or a small arbitary value ( 0.02 ) in the event that min_dist is
        // very
        // -- small)
        // -- PS.- radiusMatch can also be used here.
        MatOfDMatch good_matches = new MatOfDMatch();

        for (int i = 0; i < matchesArr.length; i++) {
            if (matchesArr[i].distance <= Math.max(2 * min_dist, 0.02)) {
                good_matches.push_back(matches.row(i));
            }
        }

        // -- Draw only "good" matches
        Mat img_matches = new Mat();
        Features2d.drawMatches(img_1, keypoints_1, img_2, keypoints_2,
                good_matches, img_matches);//, Scalar.all(-1), Scalar.all(-1),
                //null, Features2d.NOT_DRAW_SINGLE_POINTS);

        // ----Here i had to Patch around a little----
        MatOfByte matOfByte = new MatOfByte();

        Highgui.imencode(".jpg", img_matches, matOfByte);

        byte[] byteArray = matOfByte.toArray();
        BufferedImage bufImage = null;
        try {

            InputStream in = new ByteArrayInputStream(byteArray);
            bufImage = ImageIO.read(in);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        for (int i = 0; i < (int) good_matches.rows(); i++) {
            System.out.printf(
                    "-- Good Match [%d] Keypoint 1: %d  -- Keypoint 2: %d  \n",
                    i, good_matches.toArray()[i].queryIdx,
                    good_matches.toArray()[i].trainIdx);
        }

        return bufImage;

    }
}