public static void main(String[] args) {
    System.out.println("P\tQ\tAND\tOR\tXOR\tNOT(p)");

    printTable(true, true);
    printTable(true, false);
    printTable(false, true);
    printTable(false, false);
}

private static void printTable(final boolean p, final boolean q) {
    System.out.printf("%s\t", p    ? "1" : "0");
    System.out.printf("%s\t", q    ? "1" : "0");
    System.out.printf("%s\t", p&&q ? "1" : "0");
    System.out.printf("%s\t", p||q ? "1" : "0");
    System.out.printf("%s\t", p^q  ? "1" : "0");
    System.out.printf("%s\t", !p   ? "1" : "0");
    System.out.printf("\n");
}