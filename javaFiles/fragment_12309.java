public static void main(String[] args) {
    System.out.println(showControlChars("I need this\r\n" +
                                        "message to show\r\n" +
                                        "with the all \r\n" +
                                        "special characters\r\n" +
                                        "\r\n"));
}
private static String showControlChars(String input) {
    StringBuffer buf = new StringBuffer();
    Matcher m = Pattern.compile("[\u0000-\u001F\u007F]").matcher(input);
    while (m.find()) {
        char c = m.group().charAt(0);
        m.appendReplacement(buf, Character.toString(c == '\u007F' ? '\u2421' : (char) (c + 0x2400)));
        if (c == '\n') // Let's preserve newlines
            buf.append(System.lineSeparator());
    }
    return m.appendTail(buf).toString();
}