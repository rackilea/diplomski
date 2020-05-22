void russianDollPrimesGeneration(int x) {
    x *= 10;
    if (x * 10 >= 1000000) return;
    int j;
    for (int i=1; i<=9; i+=2) {
        if (i == 5) continue;
        j = x + i;
        if (isPrime(j)) {
            addToRussianDollPrimesList(j);
            russianDollPrimesGeneration(j);
        }
    }
}