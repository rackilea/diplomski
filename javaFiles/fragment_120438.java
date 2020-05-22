public static String genString(char first, int len) {
    String s = "";
    for (int i = 1 ; i < len ; i++)
        s += (char)(Math.random() * ('Z' - 'A' + 1) + 'A');
    return first + s;
}