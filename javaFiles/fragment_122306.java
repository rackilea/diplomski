/**
 * calculates the factorial of an int number.
 * This uses a simple iterative loop.
 */
public static DecimalBigInt factorial(int n) {
    DecimalBigInt fac = new DecimalBigInt(1);
    for(int i = 2; i <= n; i++) {
        fac = fac.times(new DecimalBigInt(i));
    }
    return fac;
}