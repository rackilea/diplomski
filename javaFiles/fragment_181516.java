public static void main(String[] args) {
    BinaryCalculator simple = Calculators.getBasicCalculator();
    BinaryCalculator complex = Calculators.getSofisticatedCalculator();

    double result;
    result = simple.addition(10,11);
    result = complex.addition(10,11);
}