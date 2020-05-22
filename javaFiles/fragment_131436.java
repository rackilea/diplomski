public class Addition {
    private double operand1;
    private double operand2;

    public Addition(double o1, double o2) {
        operand1 = o1;
        operand2 = o2;
    }

    public  double getSum() {
        return operand1 + operand2;
    }   

    public static void main(String[] args) {
        double res1 = new Addition(15.0, 30.0).getSum(); // Addition instance 1
        double res2 = new Addition(20.0, 30.0).getSum(); // Addition instance 2

        System.out.println("Result1: " + res1);    // Result1: 45.0
        System.out.println("Result2: " + res2);    // Result2: 50.0
    }

}