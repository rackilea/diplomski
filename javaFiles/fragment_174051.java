/*
    If number is odd,
    find the number in the keys and add 1 to its value.
    If the number is not in the keys, add it with value = 1.
 */
public static void addValue(Map<Integer, Integer> factors, int i) {
    if(i % 2 != 0) {
        int count = factors.containsKey(i) ? factors.get(i) : 0;
        factors.put(i, ++count);
    }
}

/*
    Classic algorithm to find prime numbers
 */
public static Map<Integer, Integer> oddPrimeFactors(int number) {
    int n = number;
    Map<Integer, Integer> factors = new HashMap<>();
    for (int i = 2; i <= n / i; i++) {
        while (n % i == 0) {
            addValue(factors, i);
            n /= i;
        }
    }

    if(n > 1) addValue(factors, n);
    return factors;
}