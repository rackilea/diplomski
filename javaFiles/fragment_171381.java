public static int replaceSpaces(char[] str, int length) {
    int spaceCount = 0;
    for (int i = length - 1; i >= 0; i--)
        if (str[i] == ' ')
            spaceCount++;
    int shift = spaceCount * 2;
    int newLength = length + shift;
    for (int i = newLength - 1; shift > 0; i--) {
        char c = str[i - shift];
        if (c != ' ') {
            str[i] = c;
        } else {
            str[i] = '0';
            str[--i] = '2';
            str[--i] = '%';
            shift -= 2;
        }
    }
    return newLength;
}