public static String convert(String text) {
    int offset = 64;
    StringBuilder sb = new StringBuilder(32);
    for (char c : text.toCharArray()) {
        char input = Character.toUpperCase(c);
        int value = ((int) input) - offset;
        if (value < 1 || value > 25) {
            sb.append(c);
        } else {
            sb.append(String.format("%02d", value));
        }
    }
    return sb.toString();
}