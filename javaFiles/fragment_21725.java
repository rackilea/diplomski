private static int nextPrime(int n) {
    if(n % 2 == 0)
        n++;
    for(; !isPrime(n); n+=2) { }

    return n;
}