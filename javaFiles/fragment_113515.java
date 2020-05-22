List<Integer> primes = new ArrayList<>();
      primes.add(2); // seed list with first prime

      int max = 50;
      // only check odd numbers after 2.
      for (int candidate = 3; candidate < max; candidate += 2) {

         // loop thru existing primes
         for (int p : primes) {
            // if candidate is divisible by any prime, then discontinue
            // testing and move on to next candidate via outer loop
            if (candidate % p == 0) {
               break;
            }
            // if the limit has been reached, then a prime has been
            // found, so add to list of primes and continue with
            // next candidate.
            if (p * p > candidate) {
               // add new found prime to list
               primes.add(candidate);
               break;
            }
         }
      }

      System.out.println(primes);