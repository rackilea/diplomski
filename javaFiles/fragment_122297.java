/**
 * calculates the sum of this and that.
 */
public DecimalBigInt plus(DecimalBigInt that) {
    int[] result = new int[Math.max(this.digits.length,
                                    that.digits.length)+ 1];

    addDigits(result, result.length-1, this.digits);
    addDigits(result, result.length-1, that.digits);

    // cut of leading zero, if any
    if(result[0] == 0) {
        result = Arrays.copyOfRange(result, 1, result.length);
    }
    return new DecimalBigInt(result);
}