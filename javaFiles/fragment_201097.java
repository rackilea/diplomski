public static boolean hasDistinctDigits(int number)
{
    // We rely on Java's default values here:
    // uninitialized ints will be set to 0.
    final int[] digits = new int[10];
    // But for peace of mind, we can...
    Arrays.fill(digits, 0);

    int digit;

    while (number > 0) {
        digit = number % 10;
        if (digits[digit]++ > 0)
            return false;
        number /= 10;
    }

    return true;
}