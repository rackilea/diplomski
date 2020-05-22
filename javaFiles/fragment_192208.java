Mat image = Imgcodecs.imread("C:/Users/ja/workspace/imgtomath/bin/imgtomath/lena.png");
if(image.empty() == true) {
    System.out.println("Error: no image found!");
}

List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
Mat image32S = new Mat();
image.convertTo(image32S, CvType.CV_32SC1);

Imgproc.findContours(image32S, contours, new Mat(), Imgproc.RETR_FLOODFILL, Imgproc.CHAIN_APPROX_SIMPLE);

// Draw all the contours such that they are filled in.
Mat contourImg = new Mat(image32S.size(), image32S.type());
for (int i = 0; i < contours.size(); i++) {
    Imgproc.drawContours(contourImg, contours, i, new Scalar(255, 255, 255), -1);
}

Highgui.imwrite("debug_image.jpg", contourImg); // DEBUG