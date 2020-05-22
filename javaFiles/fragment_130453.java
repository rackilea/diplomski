public static String parse(String command, String... args) {
    StringBuffer sb = new StringBuffer();
    Matcher m = Pattern.compile("\\$(\\d+)").matcher(command);
    while (m.find()) {
        int num = Integer.parseInt(m.group(1));
        m.appendReplacement(sb, args[num - 1]);
    }
    m.appendTail(sb);
    return sb.toString();
}