public static void main(String[] args) {

    // change this for different results
    int xValue = 2;

    int howManyUnknowParamsHasFunction = 1;
    int howManyDeriviationWillYouTake = 1;
    int whatIsTheIndexOfThisParameterX = 0;

    DerivativeStructure x = new DerivativeStructure(howManyUnknowParamsHasFunction, howManyDeriviationWillYouTake, whatIsTheIndexOfThisParameterX, xValue);

    // x --> x^2.
    DerivativeStructure x2 = x.pow(2);

    //y = 2x^2 + 2x - 1
    DerivativeStructure y = new DerivativeStructure(2.0, x2, 2.0, x).subtract(1);

    System.out.println("y    = " + y.getValue());
    System.out.println("y'   = " + y.getPartialDerivative(1));

}