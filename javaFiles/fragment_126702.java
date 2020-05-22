public static PointDouble interpolationByDistance(Line l, double d) {
  double len = l.p1.distance(l.p2);
  double ratio = d/len;
  double x = ratio*l.p2.x + (1.0 - ratio)*l.p1.x;
  double y = ratio*l.p2.y + (1.0 - ratio)*l.p1.y;
  System.out.println(x + ", " + y);
  ...
}