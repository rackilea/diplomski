public class Calculator {
    /**
     * returns a^b
     */
    public double power(double a, double b) {...}

    /**
     * returns the square root of a
     */
    public double squareRoot(double a) {...}
}

public class ConsoleCalculator {
    private Calculator calculator;

    public ConsoleCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    /**
     * asks for two numbers A and B, reads them from the keyboard, uses
     * the calculator to compute A^B, and displays the result on the screen
     */
    public void power() {...}

    /**
     * asks for a number A, reads it from the keyboard, uses the calculator to
     * compute the square root of A and displays the result on the screen
     */
    public void squareRoot() {...}
}