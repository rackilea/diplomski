for(int d = 2; d < Math.sqrt(n+3); d++) {
      if (n % d == 0) {
        numDivisors++;
        int check = d + n / d;
        if (primes.get(check)) {
          // **** What does done mean??? ****
          //done = true;
          numPrimeChecks++;
        } else {
          // **** Added! Got a divisor that did not check. No point in going on.
          break;
        }
      } else {
        // **** Why break here??? ****
        //break;
      }

    }