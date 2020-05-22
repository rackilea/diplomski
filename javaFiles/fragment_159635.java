public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("How many rows? ");
    int rows = keyboard.nextInt();

    triangle(rows);
    triangleReversed(rows);
}

private static void triangle(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            System.out.print(" ");
        }
        for (int j = 0; j < i * 2 + 1; j++) {
            System.out.print("*");
        }
        System.out.println("");
    }
}

private static void triangleReversed(int n) {
    for (int i = n-1; i >= 0; i--) {
        for (int j = 0; j < n - i - 1; j++) {
            System.out.print(" ");
        }
        for (int j = 0; j < i * 2 + 1; j++) {
            System.out.print("*");
        }
        System.out.println("");
    }
}