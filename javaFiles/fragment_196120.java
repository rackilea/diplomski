Mat src = Imgcodecs.imread("C:\\src1.jpg");
Mat src2 = Imgcodecs.imread("C:\\src2.jpg");
Imgproc.resize(src2, src2, new Size(100, 100));
Mat submat = src.submat(new Rect(200, 200, 100, 100));
src2.copyTo(submat);

// now you can do what you want with the src1