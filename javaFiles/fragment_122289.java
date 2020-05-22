/**
 * creates a DecimalBigInt based on an array of digits.
 * @param digits a list of digits, each between 0 (inclusive)
 *    and {@link BASE} (exclusive).
 * @throws IllegalArgumentException if any digit is out of range.
 */
public DecimalBigInt(int... digits) {
    for(int digit : digits) {
        if(digit < 0 ||  BASE <= digit) {
            throw new IllegalArgumentException("digit " + digit +
                                               " out of range!");
        }
    }
    this.digits = digits.clone();
}