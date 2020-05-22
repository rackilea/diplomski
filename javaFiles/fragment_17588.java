private static Scanner inputscan = new Scanner(System.in);
public static int betweenMethod(final int a, final int b) {
    int min = Math.min(a, b);
    int max = Math.max(a, b);
    while (true) {
        System.out.printf("Please enter a number between %d and %d%n", min, max);
        int in = inputscan.nextInt();
        if ((in == 0) || (in >= min && in <= max)) {
            return in;
        }
    }
}