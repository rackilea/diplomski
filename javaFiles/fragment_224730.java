public static int myMethod(String str, char ch) {
    int total = 0;

    for (int i = 0; i < str.length(); i++)
        if (str.charAt(i) == ch)
            total++;

    return total;
}