public static void main(String[] args) {
    String[] ss = {"OB123", "OB1212", "Maintenance", "Daily check", "OB123"};
    Collections.sort(Arrays.asList(ss), new FlightComparator());
    list(ss);
}

private static void list(String[] ss) {
    for (String s : ss) {
        System.out.println(s);
    }
}