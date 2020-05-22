public static char findFirstChar(String str, char ... chars) {
    for (char c1 : str.toCharArray())
        for (char c2 : chars)
            if (c1 == c2)
                return c1;
    return 0;
}