/**
 * does one step in the short division algorithm, i.e. divides
 *  a two-digit number by a one-digit one.
 *
 * @param result the array to put the quotient digit in.
 * @param resultIndex the index in the result array where
 *             the quotient digit should be put.
 * @param divident the last digit of the divident.
 * @param lastRemainder the first digit of the divident (being the
 *           remainder of the operation one digit to the left).
 *           This must be < divisor.
 * @param divisor the divisor.
 * @returns the remainder of the division operation.
 */
private int divideDigit(int[] result, int resultIndex,
                        int divident, int lastRemainder,
                        int divisor) {
    assert divisor < BASE;
    assert lastRemainder < divisor;

    long ent = divident + (long)BASE * lastRemainder;

    long quot = ent / divisor;
    long rem = ent % divisor;

    assert quot < BASE;
    assert rem < divisor;

    result[resultIndex] = (int)quot;
    return (int)rem;
}