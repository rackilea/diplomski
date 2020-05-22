public static List<Integer> booleanSieve(int n) {
  boolean[] primes = new boolean[n + 5];
  for (int i = 0; i <= n; i++)
    primes[i] = false;
  primes[2] = primes[3] = true;
  for (int i = 1; i <= n / 6; i++) {
    int prod6k = 6 * i;
    primes[prod6k + 1] = true;
    primes[prod6k - 1] = true;
  }
  for (int i = 0; i <= n; i++) {
    if (primes[i]) {
      int k = i;
      for (int j = k * k; j <= n && j > 0; j += k) {
        primes[j] = false;
      }
    }
  }

  List<Integer> primesList = new ArrayList<>();
  for (int i = 0; i <= n; i++)
    if (primes[i])
      primesList.add(i);

  return primesList;
}

public static List<Integer> bitPacking(int n) {
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

public static void main(String... args) {
  Executor executor = Executors.newSingleThreadExecutor();
  executor.execute(() -> {
    for (int i = 0; i < 10; i++) {
      int n = (int) Math.pow(10, i);
      Stopwatch timer = Stopwatch.createUnstarted();
      timer.start();
      List<Integer> result = booleanSieve(n);
      timer.stop();
      System.out.println(result.size() + "\tBoolean: " + timer);
    }

    for (int i = 0; i < 10; i++) {
      int n = (int) Math.pow(10, i);
      Stopwatch timer = Stopwatch.createUnstarted();
      timer.start();
      List<Integer> result = bitPacking(n);
      timer.stop();
      System.out.println(result.size() + "\tBitPacking: " + timer);
    }
  });
}