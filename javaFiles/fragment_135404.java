// find appropriate bounding rectangles
for (MatOfPoint contour : contours) {
    ...
    // test horizontal ROI orientation
    if (rect3.height > rect3.width) {
       ...
       rects.add(rect3)
    }
}