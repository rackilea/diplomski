public static BitSet sieveOfEratosthenes(int n) {
  BitSet isPrime = new BitSet(n);

  // Iniially all numbers are prime.
  for (int i = 2; i <= n; i++) {
    isPrime.set(i);
  }

  // mark non-primes <= N using Sieve of Eratosthenes
  for (int i = 2; i * i <= n; i++) {

    // if i is prime, then mark multiples of i as nonprime
    // suffices to consider mutiples i, i+1, ..., N/i
    if (isPrime.get(i)) {
      for (int j = i; i * j <= n; j++) {
          isPrime.clear(i * j);
      }
    }

  }

  //System.out.println("Found " + isPrime.cardinality() + " primes");
  return isPrime;
}