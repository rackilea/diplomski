public static void main(String[] args) throws Exception {
    printRow("A", "Category", "Quantity", "Price");
    printRow("A", "--------------", "--------------", "--------------");
    printRow("B", "Paper", 100, 200);
}

private static void printRow(String c0, String c1, Object c2, Object c3 ) {
    System.out.printf("%s %-20s %-20s %-20s%n", c0, c1, String.valueOf(c2), c3 instanceof Integer ? "$" + c3 : c3);
}