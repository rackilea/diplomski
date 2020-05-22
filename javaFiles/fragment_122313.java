/**
 * Divides this number by a small number, returning the remainder.
 * @param divisor an integer with {@code 0 < divisor < BASE}.
 * @return the remainder from the division {@code this / divisor}.
 * @throws IllegalArgumentException if the divisor is <= 0 or >= BASE.
 */
public int modulo(int divisor) {
    if(divisor <= 0 || BASE <= divisor) {
        throw new IllegalArgumentException("divisor " + divisor +
                                           " out of range!");
    }
    int[] result = new int[digits.length];
    return divideDigits(result, 0,
                        digits, 0,
                        divisor);
}