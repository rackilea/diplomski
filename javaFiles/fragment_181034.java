private static boolean containsOnly(String input, char ch) {
    if (input.isEmpty())
        return false;
    for (int i = 0; i < input.length(); i++)
        if (input.charAt(i) != ch)
            return false;
    return true;
}