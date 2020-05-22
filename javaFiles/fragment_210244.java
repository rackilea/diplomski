public static String truncate(String text, int length) {
    if (text == null || text.length() <= length)
        return text;
    int idx = text.lastIndexOf(' ', length);
    return text.substring(0, (idx != -1 ? idx : length));
}