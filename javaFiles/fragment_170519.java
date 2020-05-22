public static double [] finddistance(double X1, double Y1, double X2, double Y2, double X3, double Y3){
    double [] rv = new double [3];
    rv [0] = Math.sqrt(Math.pow((X2 - X1),2) + Math.pow((Y2 - Y1),2));
    rv [1] = Math.sqrt(Math.pow((X3 - X1),2) + Math.pow((Y3 - Y1),2));
    rv [2] = Math.sqrt(Math.pow((X3 - X2),2) + Math.pow((Y3 - Y2),2));
    return rv;
}