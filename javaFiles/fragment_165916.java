long temp = n;
while (temp != 0L) {
    int bitPosition = Long.numberOfTrailingZeros(temp) + 1;
    temp &= temp - 1L;  // Change least-significant one bit to a zero bit.

    // Do something with `bitPosition`.
}