private OLSMultipleLinearRegression getMultipleLinearRegression(List<List<Double>> pointlist) {
    OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
    double y[] = new double[pointlist.size()];
    double x[][] = new double[pointlist.size()][2];
    int c = 0;
    for (List<Double> point : pointlist) {
        y[c] = point.get(0);
        x[c][0] = point.get(1);
        x[c][1] = Math.pow(point.get(1), 2);
        regression.newSampleData(y, x);
        c++;
    }
    System.out.printf("\tR2 = %f", regression.calculateRSquared());
    return regression;
}