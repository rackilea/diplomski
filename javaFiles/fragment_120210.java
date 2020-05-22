public static void dummy(int a, int b, int expected) {
    System.out.print(System.currentTimeMillis() + "\t");
    if ((a + b) == expected) { // I don't have your Calculator :<
        System.out.println("OK");
    } else {
        System.out.println("NOK");
    }
}