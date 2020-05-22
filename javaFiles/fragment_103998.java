public static String trim(String str, char c) {
    int begIndex = 0;
    while (begIndex<str.length() && str.charAt(begIndex) == c) {
        begIndex++;
    }

    int endIndex = str.length()-1;
    while (endIndex>= 0 && str.charAt(endIndex) == c) {
        endIndex--;
    }
    return str.substring(begIndex, endIndex+1);
}