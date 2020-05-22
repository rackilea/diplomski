double[] y =  {-0.48812477, 0.33458213, -0.52754476, -0.79863471, -0.68544309,  -0.12970239, 0.02355622, -0.31890850, 0.34725819,  0.08108851};
double[][] x = {{1,0}, {0,0}, {1,0}, {2,1}, {0,1}, {0,0}, {1,0}, {0,0}, {1,0}, {0,0}};
double[][] xb = {{1,0,0}, {0,0,0}, {1,0,0}, {2,1,2}, {0,1,0}, {0,0,0}, {1,0,0}, {0,0,0}, {1,0,0}, {0,0,0}};
OLSMultipleLinearRegression regr = new OLSMultipleLinearRegression();
int degreesOfFreedomA = y.length - (x[0].length); // no + 1
int degreesOfFreedomB = y.length - (xb[0].length); // no + 1
regr.setNoIntercept(true);
regr.newSampleData(y, x);
double sumOfSquaresNoInterceptA = regr.calculateResidualSumOfSquares();
regr.newSampleData(y, xb);
double sumOfSquaresNoInterceptB = regr.calculateResidualSumOfSquares();
double MSE = sumOfSquaresNoInterceptB / degreesOfFreedomB;
System.out.printf("RSS no intercept: %f\n",sumOfSquaresNoInterceptB);
int degreesOfFreedomDifference = Math.abs(degreesOfFreedomB - degreesOfFreedomA);
double MSEdiff = Math.abs((sumOfSquaresNoInterceptB - sumOfSquaresNoInterceptA) / (degreesOfFreedomDifference));
double Fval = MSEdiff / MSE;
FDistribution Fdist = new FDistribution(degreesOfFreedomDifference, degreesOfFreedomB);
double pval = 1 - Fdist.cumulative(Fval);
System.out.printf("pval without intercept: %f",pval);