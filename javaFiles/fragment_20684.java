/**
 * Prints indexes 
 * @param character     a character in the range 'A' <= character <= 'Z'
 * @param maxNum        the maximum value to output
 */
public static void printIndexes(char character, int maxNum) {
    int index = character - 64;
    while (index <= maxNum) {
        System.out.println(index);
        index += 26;
    }
}