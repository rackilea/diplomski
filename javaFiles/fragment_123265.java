ArrayList<Integer> primes = new ArrayList<>();
final int I_MAX = 10_000; final int N_MAX = I_MAX / 10;
for (int i = 0, n = 10; i < I_MAX; i++, n++, n %= N_MAX) {
    if (i.isPrime()) primes.add(i);
    if (n == 0) System.out.println((i / (I_MAX / 10)) + "0% complete");
}