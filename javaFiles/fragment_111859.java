public class Main {
    public static void main(String[] args) {
        double[] xValues = {1572004656619D, 1572004677789D, 1572004686013D,
                            1572004693209D, 1572004698606D, 1572004707601D,
                            1572004726618D};
        double[] yValues = {51, 51, 52,
                            53, 54, 55,
                            55};

        LinearRegression linearRegression = new LinearRegression(xValues, yValues);
        System.out.println("Slope: " + linearRegression.slope());
        System.out.println("Intercept: " + linearRegression.intercept());
        System.out.println("R2: " + linearRegression.R2());

        for(int i = 0; i < yValues.length; i++){
            System.out.println("time: " + xValues[i] +
                               " value: " + yValues[i] + 
                               " trend: " + linearRegression.predict(xValues[i]));
        }
    }
}