public static void main(String[] args) {
    DecimalFormat f = new DecimalFormat("#");
    double num1 = 12345678901234567890d;
    double num2 = 314159265358979d;

    // Here's the line that does the work:
    int numberOfDigits = (int) (Math.log10(num1) + Math.log10(num2)) + 1;

    System.out.println(f.format(num1) + " * " + f.format(num2) + " = " + 
        f.format((num1 * num2)) + ", which has " + numberOfDigits + " digits");
}