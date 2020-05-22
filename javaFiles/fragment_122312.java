/**
 * Divides this number by a small number.
 * @param divisor an integer with {@code 0 < divisor < BASE}.
 * @return the integer part of the quotient, ignoring the remainder.
 * @throws IllegalArgumentException if the divisor is <= 0 or >= BASE.
 */
public DecimalBigInt divideBy(int divisor)
{
    if(divisor <= 0 || BASE <= divisor) {
        throw new IllegalArgumentException("divisor " + divisor +
                                           " out of range!");
    }

    int[] result = new int[digits.length];
    divideDigits(result, 0,
                 digits, 0,
                 divisor);
    return new DecimalBigInt(result);
}