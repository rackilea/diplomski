private static void extract(String text) {
    Pattern pattern = Pattern.compile("\\[(.*),\\s*(.*)\\]");
    Matcher matcher = pattern.matcher(text);
    if (matcher.find()) { // or .matches for matching the whole text
        String id = matcher.group(1);
        String name = matcher.group(2);
        // do something with id and name
        System.out.printf("ID: %s%nName: %s%n", id, name);
    }
}