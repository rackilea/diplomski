package test;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class MatrixMul {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        Mat A = new Mat(3, 4, CvType.CV_32FC1);
        Mat B = new Mat(4, 4, CvType.CV_32FC1);
        Mat C = new Mat(4, 3, CvType.CV_32FC1);
        Mat tmp = new Mat();
        Mat D = new Mat();

        A.put(0, 0, new float[] { 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3 });
        B.put(0, 0, new float[] { 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4 });
        C.put(0, 0, new float[] { 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3 });

        Core.gemm(B, C, 1, new Mat(), 0, tmp);
        Core.gemm(A, tmp, 1, new Mat(), 0, D);

//      Mat src = ...
//      Mat dst = new Mat();
//      Imgproc.warpPerspective(src, dst, D, new Size(3,3));

        System.out.println("A =\n" + A.dump());
        System.out.println("B =\n" + B.dump());
        System.out.println("C =\n" + C.dump());
        System.out.println("B * C =\n" + tmp.dump());
        System.out.println("D = A * (B * C) =\n" + D.dump());
    }

}