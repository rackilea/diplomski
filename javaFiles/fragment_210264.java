private static void generateDivisorsTraditional(int start, long lastFactor, Multiset<Long> primeFactors, Set<Long> divisors) {
    for (int i = start; i < primeFactors.elementSet().size(); i++) {
        long prime = Iterables.get(primeFactors.elementSet(), i);
        int count = primeFactors.count(prime);
        // ++start; remove it

        for (int c = 0; c <= count; c++) {
            long factor = ArithmeticUtils.pow(prime, c);
            divisors.add(lastFactor * factor);
            generateDivisorsTraditional(i+1, lastFactor * factor, primeFactors, divisors); // replaced start -> i+1
        }
    }
}

private static void generateDivisorsStream(int start, long lastFactor, Multiset<Long> primeFactors, Set<Long> divisors) {
    IntStream.range(start, primeFactors.elementSet().size())
            .forEach((int i) -> {
                long prime = Iterables.get(primeFactors.elementSet(), i);
                int count = primeFactors.count(prime);
                IntStream.range(0, count + 1)
                        .forEach((int c) -> {
                            long factor = ArithmeticUtils.pow(prime, c);
                            divisors.add(lastFactor * factor);
                            generateDivisorsStream(i+1, lastFactor * factor, primeFactors, divisors);
                        });
            });
}

public static void main(String[] args) {
    Multiset<Long> m = HashMultiset.create();
    m.add(1L, 1);
    m.add(2L, 1);
    m.add(5L, 1);
    Set<Long> divisors = new HashSet<>();
    generateDivisorsTraditional(1, 1, m, divisors);
    System.out.println("Traditional=> "+divisors);
    divisors = new HashSet<>();
    generateDivisorsStream(1, 1, m, divisors);
    System.out.println("Stream=> "+divisors);
}