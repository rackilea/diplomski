public double[] getHSVtoCartesian(double[] hsv) {

    double [] xy;

     double theta = hsv[0];
     double r = hsv[1];

    xy[0] = r * Math.cos(theta);
    xy[1] = r * Math.sin(theta);

    return xy;
}