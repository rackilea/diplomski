boolean isHumble(int n)
{
    for (int val : prime_factors)
        while (n % val == 0) n /= val;
    return (n == 1);
}