public static boolean valid (String a, String b) {
    if (a.length() == b.length())
        for (char c : b.toCharArray())
            if (c != '0' && (c == '1' || c == '2' || c == '3'))
                return true;
    return false;
}