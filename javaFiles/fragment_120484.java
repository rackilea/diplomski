for (int i = 0; i < contours.size(); i++) {
    double area = Imgproc.contourArea(contours.get(i));
    if (area > minArea) {
        contours.remove(i);
    }   
}