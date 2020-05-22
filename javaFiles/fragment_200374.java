public static void main(String[] args) {
    System.out.println(isReal("123.12"));
}

public static boolean isReal(String string) {
    boolean delimiterMatched = false;
    char delimiter = '.';
    for (int i = 0; i < string.length(); i++) {
        char c = string.charAt(i);
        if (!(c >= '0' && c <= '9' || c == delimiter)) {
            // contains not number
            return false;
        }
        if (c == delimiter) {
            // delimiter matched twice
            if (delimiterMatched) {
                return false;
            }
            delimiterMatched = true;
        }
    }
    // if matched delimiter once return true
    return delimiterMatched;
}