String stringReverse(String string) {
    if (string == null || string.length() == 0) {
        return string;
    }
    return stringReverse(string.substring(1)) + string.charAt(0);
 }