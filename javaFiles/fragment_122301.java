/**
 * returns the product {@code this × that}.
 */
public DecimalBigInt times(DecimalBigInt that) {
    int[] result = new int[this.digits.length + that.digits.length];
    multiplyDigits(result, result.length-1, 
                   this.digits, that.digits);

    // cut off leading zero, if any
    if(result[0] == 0) {
        result = Arrays.copyOfRange(result, 1, result.length);
    }
    return new DecimalBigInt(result);
}