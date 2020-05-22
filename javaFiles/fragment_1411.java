int k = 0;
for(int i=0; i< contours.size();i++) {
   if (Imgproc.contourArea(contours.get(i)) > 1000 && Imgproc.contourArea(contours.get(i)) < 10000 ) {
       Scalar colour = new Scalar(90,255,255);
       Imgproc.drawContours(image,contours,i,colour,-1);
       Imgproc.convexHull(contours.get(i),hull);
       List<Point> l = new ArrayList<Point>();
       l.clear();
       double sum_x = 0;
       double sum_y = 0;
       int j;
       for (j = 0; j < hull.size().height; j++) {
           l.add(contours.get(i).toList().get(hull.toList().get(j)));
           sum_x += l.get(j).x;
           sum_y += l.get(j).y;
       }
       x[0][k] = sum_x / j;
       x[1][k] = sum_y / j;
       k++;
   }
}