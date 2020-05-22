public static int charPosition(String word, char letter) {
    int answer = 0, x;
    char[] charArray = word.toCharArray();
    for (x = 0; x < word.length(); x++) {
        if (charArray[x] == letter) {     // <−−−−−− Change is here
            answer = x;
        } else {
            answer = -1;
        }
    }
    return answer;
}