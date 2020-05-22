/**
 * multiplies two digits and adds the product to the result array
 * at the right digit-position.
 */
private void multiplyDigit(int[] result, int resultIndex,
                           int firstFactor, int secondFactor) {
    long prod = (long)firstFactor * (long)secondFactor;
    int prodDigit = (int)(prod % BASE);
    int carry = (int)(prod / BASE);
    addDigits(result, resultIndex, carry, prodDigit);
}