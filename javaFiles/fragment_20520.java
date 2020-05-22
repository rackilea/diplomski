public class QTwoAssiThree {
    private int numerator;
    private int denominator;

    public void writeOutput() {

        System.out.println(toString() + " is the rational number entered.");
        if (simplify(numerator, denominator)>1)
            System.out.println(toString()+ " is the simplified rational number.");
        else
            System.out.println(toString()+ " is what was entered, and is already in its simplest form.");
        System.out .println(getValue() +" is the value of the two rational numbers as one number.");
    }

    public QTwoAssiThree() {
        numerator = 0;
        denominator = 0;
    }

    public QTwoAssiThree(int initialNum, int initialDenom) {

        numerator = initialNum;
        denominator = initialDenom;
        if (initialDenom <= 0) {
            System.out
                    .println("Invalid value added as the denominator! Only positive integers should be used.");
            System.exit(0);
        }
    }

    private int simplify(int newNum, int newDenom) {
        int gcd = getGCD(newNum, newDenom);
        numerator = newNum / gcd;
        denominator = newDenom / gcd;
        return gcd;
    }

    private static int getGCD(int x, int y) {

        if (y == 0) {
            return x;
        }
        return getGCD(y, x % y);
    }

    private double getValue() {
        double doubleValue = (double) numerator / (double) denominator;

        return doubleValue;
    }

    public String toString() {
        String fraction = Integer.toString(numerator) + "/"
                + Integer.toString(denominator);

        return fraction;
    }
}