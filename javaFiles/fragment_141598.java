public static  int sumDigits(int n)
{
    int m = n % 10, next = n / 10;
    if (next == 0) {
        return m;
    }
    return m + sumDigits(next);
}