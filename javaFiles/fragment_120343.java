private static void reverseCharArray(char[] result, int start, int end) {
    int halfDifference = (end - start) / 2;
    for (int i = 0; i < halfDifference; i++) {
        char buffer = result[start + i];
        result[start + i] = result[end - i - 1];
        result[end - i - 1] = buffer;
    }
}    

public static String reverseWordInString(String string) {
    char[] stringAsCharArray = string.toCharArray();

    int indexStart = 0;
    for (int indexEnd = 0; indexEnd < stringAsCharArray.length; indexEnd++) {
        if (stringAsCharArray[indexEnd] != ' ') {
            continue;
        }
        StringOperations.reverseCharArray(stringAsCharArray, indexStart, indexEnd);
        indexStart = indexEnd + 1;
    }
    StringOperations.reverseCharArray(stringAsCharArray, indexStart, stringAsCharArray.length);

    return String.valueOf(stringAsCharArray);
}