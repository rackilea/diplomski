private PolynomialFunction getPolynomialFitter(List<List<Double>>pointlist) {

final PolynomialCurveFitter fitter = PolynomialCurveFitter.create(2);

final WeightedObservedPoints obs = new WeightedObservedPoints();
for (List<Double> point : pointlist) {
    obs.add(point.get(0), point.get(1));
}

double[] fit = fitter.fit(obs.toList());
System.out.printf("\nCoefficient %f, %f, %f", fit[0], fit[1], fit[2]); 

final PolynomialFunction fitted = new PolynomialFunction(fit);
return fitted;
}