public static int[] firstNPrimes (int n){
      int[] primes = new int[n];
      int ncounter = 0;
      int isPrime = 2;
      while( ncounter < n){
        boolean prime = true;
        for (int j=2; j<isPrime; j++){
          if (isPrime%j ==0){
            prime = false;
            break;
          }
        }
        if (prime){
          primes[ncounter] = isPrime;
          ncounter++;
        } 
        isPrime++;
       }
      return primes;
    }