/**
 * Return the number of occurences of a character in the specified String.
 * 
 * @param string the string to search
 * @param searchChar the char to search for
 * @return the number of occurences of searchChar in string
 */
public int countChars(String string, char searchChar) {
    int count = 0;
    for (int i = 0; i < string.length(); i++) {
        char c = string.charAt(i);
        if (c == searchChar) {
            count++;
        }
    }
    return count;
}