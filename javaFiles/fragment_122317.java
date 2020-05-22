/**
 * Converts the number to a String in a given radix.
 * This uses {@link Character.digit} to convert each digit
 * to one character.
 * @param radix the radix to use, between {@link Character.MIN_RADIX}
 *   and {@link Character.MAX_RADIX}.
 * @return a String containing the digits of this number in the
 *   specified radix, using '0' .. '9' and 'a' .. 'z' (as much as needed).
 */
public String toString(int radix) {
    if(radix < Character.MIN_RADIX || Character.MAX_RADIX < radix) {
        throw new IllegalArgumentException("radix out of range: " + radix);
    }
    if(digits.length == 0)
        return "0";
    int[] rdigits = convertTo(radix);
    StringBuilder b = new StringBuilder(rdigits.length);
    for(int dig : rdigits) {
        b.append(Character.forDigit(dig, radix));
    }
    return b.toString();
}