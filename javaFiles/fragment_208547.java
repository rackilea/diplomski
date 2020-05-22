final List<MatOfPoint> contours = new ArrayList<>();
    findContours(outerBox, contours, new Mat(outerBox.size(), outerBox.type()), CV_SHAPE_RECT, CHAIN_APPROX_SIMPLE);

    final Integer biggestPolygonIndex = getBiggestPolygonIndex(contours);
    if (biggestPolygonIndex != null) {
        final MatOfPoint biggest = contours.get(biggestPolygonIndex);
        List<Point> corners = getCornersFromPoints(biggest.toList());
        System.out.println("corner size " + corners.size());
        for (Point corner : corners) {
            drawMarker(originalImage, corner, new Scalar(0,191,255), 0, 20, 3);
        }

        setGreenFrame(contours, biggestPolygonIndex, originalImage);
    }

private List<Point> getCornersFromPoints(final List<Point> points) {
    double minX = 0;
    double minY = 0;
    double maxX = 0;
    double maxY = 0;


    for (Point point : points) {
        double x = point.x;
        double y = point.y;

        if (minX == 0 || x < minX) {
            minX = x;
        }
        if (minY == 0 || y < minY) {
            minY = y;
        }
        if (maxX == 0 || x > maxX) {
            maxX = x;
        }
        if (maxY == 0 || y > maxY) {
            maxY = y;
        }
    }

    List<Point> corners = new ArrayList<>(4);
    corners.add(new Point(minX, minY));
    corners.add(new Point(minX, maxY));
    corners.add(new Point(maxX, minY));
    corners.add(new Point(maxX, maxY));

    return corners;
}

private Integer getBiggestPolygonIndex(final List<MatOfPoint> contours) {
    double maxVal = 0;
    Integer maxValIdx = null;
    for (int contourIdx = 0; contourIdx < contours.size(); contourIdx++) {
        double contourArea = contourArea(contours.get(contourIdx));
        if (maxVal < contourArea) {
            maxVal = contourArea;
            maxValIdx = contourIdx;
        }
    }

    return maxValIdx;
}

private void setGreenFrame(final List<MatOfPoint> contours,
                           final int biggestPolygonIndex,
                           Mat originalImage) {
    drawContours(originalImage, contours, biggestPolygonIndex, new Scalar(124,252,0), 3);
}