static double getTotalSides(MyPolygon... polygons) {
  double x = 0;

  for (MyPolygon p: polygons)
  {
   x+= p.getSides();
  }
   return x;
}