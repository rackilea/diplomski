public static List<Integer> primeFactors(int numbers) {
    int n = numbers;
    List<Integer> factors = new ArrayList<>();
    for (int i = 2; n>1; i++) {
        while (n % i == 0) {
            factors.add(i);
            n /= i;
        }
    }
    z = Collections.max(factors);
    return factors;
}