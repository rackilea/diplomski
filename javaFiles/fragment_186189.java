public void primesTo1000() {
    Set<Integer> notPrimes = new HashSet<>();
    ArrayList<Integer> primes = new ArrayList<>();
    primes.add(2);//explicitly add
    primes.add(3);//2 and 3

    for (int i = 1; i < (1000 / 6); i++) {
      handlePossiblePrime(6 * i - 1, primes, notPrimes);
      handlePossiblePrime(6 * i + 1, primes, notPrimes);
    }
    System.out.println(primes);
  }

  public void handlePossiblePrime(
      int k, List<Integer> primes, Set<Integer> notPrimes) {
    if (!notPrimes.contains(k)) {
      primes.add(k);
      for (int j = k * k; j <= 1000; j += k) {
        notPrimes.add(j);
      }
    }
  }