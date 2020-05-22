int[] primes(int num) {
    boolean[] bool = new boolean[num];
    Arrays.fill(bool, true);
    int count = num;
    for (int i = 2; i < Math.sqrt(num); i++) {
        if(bool[i]) {
            for(int j = (i * i); j < num; j = j + i) {
                bool[j] = false;
                count--;
            }
        }
    }
    int[] primes = new int[count];
    for (int i = 2; i< bool.length; i++) {
        if(bool[i]) {
            primes[count - 1] = i;
        }
    }
    return primes;
}