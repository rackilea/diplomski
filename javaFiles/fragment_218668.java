ArrayList<Coordinate> coords = new ArrayList<>();
// start at the tower
coords.add(point.getCoordinate());
// next the edge of the wedge
int nSteps = 10;
// assume width of 10 degrees
double width = 10.0;
double dStep = width/nSteps;
for (int i = -nSteps; i < nSteps; i++) {
  CALC.setStartingGeographicPoint(point.getX(), point.getY());
  CALC.setDirection((azimuth +(i*dStep)), radius);
  Point2D p = CALC.getDestinationGeographicPoint();
  coords.add(new Coordinate(p.getX(), p.getY()));
}
// end at the tower
coords.add(point.getCoordinate());
poly = GF.createPolygon(coords.toArray(new Coordinate[] {}));