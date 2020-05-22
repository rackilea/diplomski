private static void processFile(String contents) {

    Pattern p = Pattern.compile(
            "Object name\\.{7}: (.++)|"
            + "\\{CAT=([^\\}]++)\\}|"
            + "\\{CODE=([^\\}]++)\\}|"
            + "\\{DESC=([^\\}]++)\\}");

    Matcher m = p.matcher(contents);

    while (m.find()) {
        if (m.start(1) != -1) {
            System.out.printf("%ncreating new component...%n");
            System.out.printf("  name: %s%n", m.group(1));
        } else if (m.start(2) != -1) {
            System.out.printf("  category: %s%n", m.group(2));
        } else if (m.start(3) != -1) {
            System.out.printf("  order code: %s%n", m.group(3));
        } else if (m.start(4) != -1) {
            System.out.printf("  description: %s%n", m.group(4));
        }
    }
}