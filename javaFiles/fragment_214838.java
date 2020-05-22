private double getRSquare(PolynomialFunction fitter, List<List<Double>> pointList) {

final double[] coefficients = fitter.getCoefficients();
double[] predictedValues = new double[pointList.size()];
double residualSumOfSquares = 0;
final DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();

for (int i=0; i< pointList.size(); i++) {
    predictedValues[i] = predict(coefficients, pointList.get(i).get(0));

    double actualVal = pointList.get(i).get(1);
    double t = Math.pow((predictedValues[i] - actualVal), 2);
    residualSumOfSquares  += t;
    descriptiveStatistics.addValue(actualVal);
}
final double avgActualValues = descriptiveStatistics.getMean();
double totalSumOfSquares = 0;
for (int i=0; i<pointList.size(); i++) {
    totalSumOfSquares += Math.pow( (predictedValues[i] - avgActualValues),2);

}
return 1.0 - (residualSumOfSquares/totalSumOfSquares);
}