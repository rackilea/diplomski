List<Rect> rectsOnSourcemat = new ArrayList<>();

for (MatOfPoint contour : contours) {
    MatOfPoint2f contourPoints = new MatOfPoint2f(contour.toArray());
    RotatedRect boundingRect = Imgproc.minAreaRect(areaPoints);
    Point rotated_rect_points[] = new Point[4];
    boundingRect.points(rotated_rect_points);

    // correct coords here for sourceMat:
    for (int ixPoint = 0; ixPoint < 4; ixPoint++) {
        rotated_rect_points[ixPoint].x += topLeftX;  
        rotated_rect_points[ixPoint].y += topLeftY;  
    }

    // crate bounding rect for sourceMat
    Rect rect = Imgproc.boundingRect(new MatOfPoint(rotated_rect_points));
    rectsOnSourcemat.add(rect);
}