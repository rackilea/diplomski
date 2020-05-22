public static boolean isDigitsOrSpecial(String in) {
    if (in != null) {
        for (char ch : in.toCharArray()) {
            if (Character.isLetter(ch)) {
                return false;
            }
        }
    }
    return true;
}