public static String padString(String in, char padChar, int length) {
    StringBuilder sb = new StringBuilder(length);
    sb.append(in);
    for (int i = in.length(); i < length; i++) {
        sb.insert(0, padChar);
    }
    return sb.toString();
}