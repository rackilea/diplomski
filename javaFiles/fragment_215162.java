public static void solveSimultaneousEquations(double a, double b, double c, double d, double e, double f) {
    double det = ((a) * (d) - (b) * (c));  //instead of 1/
    double x = ((d) * (e) - (b) * (f)) / det;
    double y = ((a) * (f) - (c) * (e)) / det;
    System.out.print("x=" + x + " y=" + y);
}