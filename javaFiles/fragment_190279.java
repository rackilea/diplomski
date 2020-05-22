private static void processFile(ArrayList<String> lines) {

    Pattern p = Pattern.compile(
            "Object name\\.{7}: (.++)|"
            + "\\{CAT=([^\\}]++)\\}|"
            + "\\{CODE=([^\\}]++)\\}|"
            + "\\{DESC=([^\\}]++)\\}");

    // Create the Matcher now and reassign it to each line as we go.
    Matcher m = p.matcher("");

    for (String line : lines) {
        if (m.reset(line).find()) {
            // If group #n participated in the match, start(n) will be non-negative.
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
}