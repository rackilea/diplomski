static boolean isSmith(int v) {
      int sum = 0;
      int save = v;

      int lastPrime = primes.get(primes.size() - 1);
      if (lastPrime < v) {
         genPrimes(v);
      }
      outer:
      for (int p : primes) {
         while (save > 1) {
            if (save % p != 0) {
               continue outer;
            }
            sum += sumOfDigits(p);
            save /= p;
         }
         break;
      }
      return sum == sumOfDigits(v) && !primes.contains(v);
   }