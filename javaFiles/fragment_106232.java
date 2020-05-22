public static String changeLetters(String str) {
    String str1 = "";
    for (int i = 0; i < str.length(); i++) {
        if (i + 1 >= str.length()) {
            str1 += str.charAt(i);
            return str1;
        }
        char ch3 = '\u0000';
        char ch1 = str.charAt(i);
        char ch2 = str.charAt(i + 1);
        if (i + 2 < str.length()) {
            ch3 = str.charAt(i + 2);
        }
        if ((ch1 == 116) && (ch2 == 112)) {
            i++;
            str1 = str1 + ch1 + ch2;
        } else if ((ch1 == 116) && (ch2 != 112) && (ch3 == 112)) {
            i = i + 2;
            ch2 = ch3;
            str1 = str1 + ch1 + ch2;
        } else {
            str1 = str1 + ch1;
        }
    }
    return str1;
}