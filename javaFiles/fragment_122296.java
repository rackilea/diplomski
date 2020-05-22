/**
 * adds all the digits from the addend array to the result array.
 */
private void addDigits(int[] result, int resultIndex,
                       int... addend)
{
    addendIndex = addend.length - 1;
    while(addendIndex >= 0) {
        addDigit(result, resultIndex,
                 addend[addendIndex]);
        addendIndex--;
        resultIndex--;
    }
}