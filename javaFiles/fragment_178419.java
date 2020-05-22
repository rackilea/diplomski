private static Scanner sc;

public static int read() {

    return sc.nextInt();
}

public static void out(final int a, final int b) {
    System.out.println("Sum: " + (a + b));
    System.out.println("Difference: " + (a - b));
    System.out.println("Product: " + a * b);
    System.out.println("Quotient: " + (double) a / (double) b);
    System.out.println("Remainder: " + a % b);
}

public static void main(final String[] args) {
    System.out.println("Please enter two integers!:");
    sc = new Scanner(System.in);
    int a = read();
    int b = read();
    sc.close();
    out(a, b);
}