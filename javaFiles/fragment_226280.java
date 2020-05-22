public static String removeLeadingAndTrailingSpaces(String s) {
    int end = s.length();
    int i = 0;

    while (i < end && s.charAt(i) == ' ') {
        i++;
    }

    while (end > i && s.charAt(end - 1) == ' ') {
        end--;
    }

    return end> i ? s.substring(i, end) : "";
}