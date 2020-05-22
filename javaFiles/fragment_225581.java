static {
    for (int candidate = 2, count = 0; count < n; ++candidate) {
        if (isPrime(candidate)) {
            ++count;
            listofPrimes.add(candidate); 
        }
    }
}