private static int firstVowel(String s) {
    int index = -1;
    for (int i = 0; i < s.length; ++i ) {
        if (isVowel(s.charAt(i)) {
            index = i;
            break;
        }
    }
    return index;
}