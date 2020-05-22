public static char findFirstChar(String str, char c1, char c2) {
    for (char c : str.toCharArray())
        if (c == c1 || c == c2)
            return c;
    return 0;
}