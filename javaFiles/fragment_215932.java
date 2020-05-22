public static int count_Vowels(String str) {
    int a = 0, e = 0, i = 0, o = 0, u = 0;
    for (char ch : str.toLowerCase().toCharArray()) {
        if (ch == 'a') {
            a = 1;
        } else if (ch == 'e') {
            e = 1;
        } else if (ch == 'i') {
            i = 1;
        } else if (ch == 'o') {
            o = 1;
        } else if (ch == 'u') {
            u = 1;
        }
    }
    return a + e + i + o + u;
}