// ... 
CvSeq contours = new CvSeq();
CvSeq ptr = new CvSeq();
CvRect rect = null;
// ...
cvFindContours(..., contours, ...);

for (ptr = contours; ptr != null; ptr = ptr.h_next()) {
    rect =  cvBoundingRect(ptr, 0);
    // ... Draw the box if meets criteria
}