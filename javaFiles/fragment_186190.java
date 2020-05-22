public List<Integer> primesTo(int n) {
  List<Integer> primes = new ArrayList<>();
  if (n > 1) {
    int limit = (n - 3) >> 1;
    int[] sieve = new int[(limit >> 5) + 1];
    for (int i = 0; i <= (int) (Math.sqrt(n) - 3) >> 1; i++)
      if ((sieve[i >> 5] & (1 << (i & 31))) == 0) {
        int p = i + i + 3;
        for (int j = (p * p - 3) >> 1; j <= limit; j += p)
          sieve[j >> 5] |= 1 << (j & 31);
      }
    primes.add(2);
    for (int i = 0; i <= limit; i++)
      if ((sieve[i >> 5] & (1 << (i & 31))) == 0)
        primes.add(i + i + 3);
  }
  return primes;
}