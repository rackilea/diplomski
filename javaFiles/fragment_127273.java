if (n <= 0)
    throw new IllegalArgumentException("Not a positive number: " + n);
for (; n > 0; n /= 10) {
    int digit = n % 10;
    // use digit here
}