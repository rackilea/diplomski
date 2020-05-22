public static int charPosition(String word, char letter) {
    int answer = -1, x;
    char[] charArray = word.toCharArray();
    for (x = 0; x < charArray.length; x++) { // <−−−
        if (charArray[x] == letter) {        // <−−−
            answer = x;
            break;                           // <−−−
        }
    }
    return answer;
}