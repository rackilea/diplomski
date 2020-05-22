List<MatOfPoint> contours = new ArrayList<>();
Mat hierarchy = new Mat();
Imgproc.findContours(middle, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

// now iterate over all top level contours
for(int idx = 0; idx >= 0; idx = (int) hierarchy.get(0, idx)[0]) {
    MatOfPoint matOfPoint = contours.get(idx);
    Rect rect = Imgproc.boundingRect(matOfPoint);
    Imgproc.rectangle(originalImage, rect.tl(), rect.br(), new Scalar(0, 0, 255));
}