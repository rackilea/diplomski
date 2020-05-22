/**
 * adds one digit from the addend to the corresponding digit
 * of the result.
 * If there is carry, it is recursively added to the next digit
 * of the result.
 */
private void addDigit(int[] result, int resultIndex,
                      int addendDigit)
{
    int sum = result[resultIndex] + addendDigit;
    result[resultIndex] = sum % BASE;
    int carry = sum / BASE;
    if(carry > 0) {
        addDigit(result, resultIndex - 1, carry);
    }
}