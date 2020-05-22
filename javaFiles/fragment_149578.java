public static void main(String[] args) throws Exception {
    Pattern p = Pattern
            .compile(".*?(\\d{1,3}(?:\\s+\\d{3})*)\\s*(\\d{1,3}(?:\\s+\\d{3})*)\\s*(\\d{1,3}(?:\\s+\\d{3})*)");
    List<String> list = Arrays.asList("Bolighus fullverdi 4 374 720 12 000 11 806",
            "Andre bygninger 313 400 6 000 370");

    for (String s : list) {
        Matcher m = p.matcher(s);
        if (m.matches()) {
            System.out.println("For string: " + s);
            System.out.println(m.group(1).replaceAll(" ", ""));
            System.out.println(m.group(2).replaceAll(" ", ""));
            System.out.println(m.group(3).replaceAll(" ", ""));
        } else {
            System.out.println("For string: '" + s + "' Didn't match");
        }
        System.out.println();
    }
}