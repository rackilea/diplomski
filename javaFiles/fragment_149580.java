public static void main(String[] args) throws Exception {
    Pattern p = Pattern
            .compile(".*?(\\d{1,3}(?:\\s+\\d{3})*)\\s*(\\d{1,3}(?:\\s+\\d{3})*)");
    List<String> list = Arrays.asList("Innbo Ekstra Nordea 1 500 000 1 302");

    for (String s : list) {
        Matcher m = p.matcher(s);
        if (m.matches()) {
            System.out.println("For string: " + s);
            System.out.println(m.group(1).replaceAll(" ", ""));
            System.out.println(m.group(2).replaceAll(" ", ""));
        } else {
            System.out.println("For string: '" + s + "' Didn't match");
        }
        System.out.println();
    }
}