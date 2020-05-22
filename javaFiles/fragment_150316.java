public static void printTemplateArray(char[] tmpArr,
        Set<Character> guesses) {
    char[] qMark = new char[tmpArr.length];
    for (int i = 0; i < tmpArr.length; i++) {
        if (tmpArr[i] == ' ') {
            qMark[i] = ' ';
        } else if (guesses.contains(tmpArr[i])) {
            qMark[i] = tmpArr[i];// copy already guessed char
        } else {
            qMark[i] = '?';
        }
    }

    System.out.print(qMark);
}