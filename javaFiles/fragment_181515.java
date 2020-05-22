public class Calculators {

    public static BinaryCalculator getBasicCalculator(){
        return new BinaryCalculator() {

            @Override
            public double addition(double numb1, double numb2) {
                return numb1 + numb2;
            }
        };
    }

    public static BinaryCalculator getSofisticatedCalculator(){
        return new BinaryCalculator() {

            @Override
            public double addition(double numb1, double numb2) {
                //do any other sofisticated calculation
                return numb1 + numb2;
            }
        };
    }

}