private static String reverseString(String s) {
    char[] orig = s.toCharArray();
    char[] reverse = new char[orig.length];
    for (int i = 0; i < orig.length; i++) {    
        reverse[i] = orig[orig.length - i - 1];
    }
    return new String(reverse);
}