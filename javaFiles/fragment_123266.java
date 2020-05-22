ArrayList<Integer> primes = new ArrayList<>();
final int I_MAX = 10_000;
for (int i = 0; i < I_MAX; i++) {
    if (i.isPrime()) primes.add(i);
    if (i % (I_MAX / 10) == 0) System.out.println((i / (I_MAX / 10)) + "0% complete");
}