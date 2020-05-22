private static String addSpacesEvery5(String s) {
    // s.length() / 5 is how many spaces we will add
    char[] charArray = new char[s.length() + s.length() / 5];
    int currentPos = 0;
    for (int i = 0 ; i < s.length() ; i++) {
        if (i % 5 == 0 && i != 0) {
            charArray[currentPos] = ' ';
            currentPos++;
        }
        charArray[currentPos] = s.charAt(i);
        currentPos++;
    }
    return new String(charArray);
}