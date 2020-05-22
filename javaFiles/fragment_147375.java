private static void printPrimes(int lower_bound, int upper_bound) {
    ArrayList<Integer> primesList = GeneratePrimesSieveOfEratosthenes(upper_bound);

    for (int i = 0; i < primesList.size(); i++) {
        if (primesList.get(i) <= lower_bound)
            System.out.println(primesList.get(i));
    }
}