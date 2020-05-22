public static BitArray SieveOfSundaram(int limit)
{
    limit /= 2;
    BitArray bits = new BitArray(limit + 1, true);
    for (int i = 1; 3 * i + 1 < limit; i++)
    {
        for (int j = 1; i + j + 2 * i * j <= limit; j++)
        {
            bits[i + j + 2 * i * j] = false;
        }
    }
    return bits;
}

public static List<int> GeneratePrimesSieveOfSundaram(int n)
{
    int limit = ApproximateNthPrime(n);
    BitArray bits = SieveOfSundaram(limit);
    List<int> primes = new List<int>();
    primes.Add(2);
    for (int i = 1, found = 1; 2 * i + 1 <= limit && found < n; i++)
    {
        if (bits[i])
        {
            primes.Add(2 * i + 1);
            found++;
        }
    }
    return primes;
}