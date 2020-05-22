public static boolean isRealRecursive(String string) {
         return isRealRecursive(string, 0, false);
    }

    private static boolean isRealRecursive(String string, int position, boolean delimiterMatched) {
        char delimiter = '.';
        if (position == string.length()) {
            return delimiterMatched;
        }
        char c = string.charAt(position);
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
        return isRealRecursive(string, position+1, delimiterMatched);
    }