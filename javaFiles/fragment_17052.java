GeodeticCalculator calc = new  GeodeticCalculator(DefaultGeographicCRS.WGS84);
  calc.setStartingGeographicPoint(point.getX(), point.getY());
  calc.setDirection(0.0, 10000);
  Point2D p2 = calc.getDestinationGeographicPoint();
  calc.setDirection(90.0, 10000);
  Point2D p3 = calc.getDestinationGeographicPoint();

  double dy = p2.getY() - point.getY();
  double dx = p3.getX() - point.getX();
  double distance = (dy + dx) / 2.0;
  Polygon p1 = (Polygon) point.buffer(distance);