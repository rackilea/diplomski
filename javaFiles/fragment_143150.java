private double[] multiplyArray(double[] y){
    // An array 2 or 4 or N times bigger than the original:
    double[] yy = new double[y.length*arrayMultiplier];
    // An array representing the indices of the original:
    double[] x = new double[y.length];
    for(int i = 0; i < x.length; i++)
        x[i] = i;
    // Get and instance of SplineInterpolator:
    SplineInterpolator splineInterp = new SplineInterpolator();
    // Use that instance's interpolate() function to a PolynomialSplineFunction
    // fitting your data, points y at indices x.
    PolynomialSplineFunction polySplineF = splineInterp.interpolate(x, y);

    // Use the PolynomialSplineFunction to fill in your larger array by supplying
    // index values divided by the arrayMultiplier
    for(int i = 0; i < yy.length; i++){
        yy[i] = polySplineF.value((double)(i/arrayMultiplier));
    }
    return yy;
}