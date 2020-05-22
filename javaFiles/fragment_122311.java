/**
 * The short division algorithm, like described in
 * <a href="http://en.wikipedia.org/wiki/Short_division">Wikipedia's
 *   article <em>Short division</em></a>.
 * @param result an array where we should put the quotient digits in.
 * @param resultIndex the index in the array where the highest order digit
 *     should be put, the next digits will follow.
 * @param divident the array with the divident's digits. (These will only
 *          be read, not written to.)
 * @param dividentIndex the index in the divident array where we should
 *         start dividing. We will continue until the end of the array.
 * @param divisor the divisor. This must be a number smaller than
 *        {@link #BASE}.
 * @return the remainder, which will be a number smaller than
 *     {@code divisor}.
 */
private int divideDigits(int[] result, int resultIndex,
                         int[] divident, int dividentIndex,
                         int divisor) {
    int remainder = 0;
    for(; dividentIndex < divident.length; dividentIndex++, resultIndex++) {
        remainder = divideDigit(result, resultIndex,
                                divident[dividentIndex],
                                remainder, divisor);
    }
    return remainder;
}