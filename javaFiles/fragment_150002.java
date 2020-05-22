private static int convertToDigits(String input) {
    if (input.isEmpty()) {
        return 0;
    }
    StringBuilder builder = new StringBuilder(input.length());
    for (char c : input.toCharArray()) {
        if('0' <= c && c <= '9') {
            builder.append(c);
        }
    }
    return Integer.parseInt(builder.toString());
}