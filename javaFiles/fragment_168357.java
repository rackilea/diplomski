static List<Integer> primes = new ArrayList<>(List.of(2, 3));
   static void genPrimes(int max) {
      int next = primes.get(primes.size() - 1);
      outer:
      while (next <= max) {
         next += 2;
         for (int p : primes) {
            if (next % p == 0) {
               continue outer;
            }
            if (p * p > next) {
               break;
            }
         }
         primes.add(next);
      }
   }
}