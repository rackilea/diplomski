public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Get the sum from System.in.
    int sum = sc.nextInt();

    // If the given sum is odd, return immediately.
    // No Pythagorean triple will have an odd sum.
    if ((sum ^ 1) == 1) {
        return;
    }

    // Try all values of a within the expected bounds.
    int aBound = sum / 2;
    for (int a = 1; a < aBound; a++) {
        // Check whether b would be a whole number with this value of a.
        if ((a * sum) % (a - sum) == 0) {
            int b = (sum * (2 * a - sum)) / (2 * a - 2 * sum);
            int c = sum - a - b;
            System.out.println((int)Math.pow(c, 2));
            break;
        }
    }
}