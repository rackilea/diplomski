public static void main(String[] args) {
    int value = 40;
    int divisor = 5;
    int result = (value / divisor) * divisor;
    System.out.println("Exact: " + result); // outputs 40

    value = 43;
    result = (value / divisor) * divisor;
    System.out.println("Inexact: " + result); // outputs 40
}