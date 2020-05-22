// obtain your homography mat (picked your parameters.. you have to play to get the right results)
Mat homography = Calib3d.findHomography(src, dst, Calib3d.RANSAC, 10);
// image you want to transform
Mat image = Highgui.imread("image/img.jpg");
// outputMat will contain the perspectively changed image
Imgproc.warpPerspective(image, outputMat, homography, new Size(image.cols(), image.rows()));