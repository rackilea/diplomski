public static void main(String[] args) {
    String[][] strings = { { "AAA", "BBB", "CCC" }, { "AAAA", "B", "C" },
            { "Z" }, { "", "" } };
    for (String[] arr : strings) {
        System.out.printf("%s => %d%n", Arrays.toString(arr), maxString(arr));
    }
}