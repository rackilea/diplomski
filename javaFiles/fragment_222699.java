class Point {
  double x,y;

  Point(double pX, double pY){
    this.x= pX;
    this.y= pY;
  }

  public double distance(Point A1, Point A2){
    double numerator = Math.abs((A2.y - A1.y)*this.x + (A2.x - A1.x)*this.y + A2.x*A1.y - A2.y*A1.x);
    double denominator = Math.sqrt(Math.pow(A2.y - A1.y,2) + Math.pow(A2.x - A1.x,2));

    return numerator/denominator;       
  }

}