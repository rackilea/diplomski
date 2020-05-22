private Bitmap findRoi(Bitmap sourceBitmap) {
    Bitmap roiBitmap = null;
    Scalar green = new Scalar(0, 255, 0, 255);
    Mat sourceMat = new Mat(sourceBitmap.getWidth(), sourceBitmap.getHeight(), CvType.CV_8UC3);
    Utils.bitmapToMat(sourceBitmap, sourceMat);
    Mat roiTmp = sourceMat.clone();

    final Mat hsvMat = new Mat();
    sourceMat.copyTo(hsvMat);

    // convert mat to HSV format for Core.inRange()
    Imgproc.cvtColor(hsvMat, hsvMat, Imgproc.COLOR_RGB2HSV);

    Scalar lowerb = new Scalar(85, 50, 40);         // lower color border for BLUE
    Scalar upperb = new Scalar(135, 255, 255);      // upper color border for BLUE
    Core.inRange(hsvMat, lowerb, upperb, roiTmp);   // select only blue pixels

    // find contours
    List<MatOfPoint> contours = new ArrayList<>();
    List<RotatedRect> boundingRects = new ArrayList<>();
    Imgproc.findContours(roiTmp, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);

    // find appropriate bounding rectangles
    for (MatOfPoint contour : contours) {
        MatOfPoint2f areaPoints = new MatOfPoint2f(contour.toArray());
        RotatedRect boundingRect = Imgproc.minAreaRect(areaPoints);

        double rectangleArea = boundingRect.size.area();

        // test min ROI area in pixels
        if (rectangleArea > 400) {
            Point rotated_rect_points[] = new Point[4];
            boundingRect.points(rotated_rect_points);

            Rect rect = Imgproc.boundingRect(new MatOfPoint(rotated_rect_points));

            // test horizontal ROI orientation
            if (rect.width > rect.height) {
                Imgproc.rectangle(sourceMat, rect.tl(), rect.br(), green, 3);
            }
        }
    }

    roiBitmap = Bitmap.createBitmap(sourceMat.cols(), sourceMat.rows(), Bitmap.Config.ARGB_8888);
    Utils.matToBitmap(sourceMat, roiBitmap);
    return roiBitmap;
}