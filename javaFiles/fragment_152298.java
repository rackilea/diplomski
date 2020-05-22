public class functiond {

    public static double itemCount = 1.99;
    public static double dollarsProvided = 2.00;

    public static double makeChange() {
        double change = dollarsProvided - itemCount;
        return change;
    }
    public static void main(String[] args) {
        System.out.println(makeChange());
    }
}