public static void main(final String[] args) throws InterruptedException {
    int[] digits = new int[3];
    final Console c = System.console();
    while (true) {
        final int n = Math.abs(Integer.parseInt(c.readLine("Enter your number: ")));
        if (n == 0) {
            break;
        }
        digits[(int) Math.floor(Math.log10(n))]++;
    }
    System.out.println(Arrays.toString(digits));
}