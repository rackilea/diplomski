static Map<Integer, BigInteger> storage = new HashMap<>();

public static void main(String[] args) {
    Scanner sx = new Scanner(System.in);

    // Add 0 and 1.
    storage.put(0, BigInteger.valueOf(sx.nextInt()));
    storage.put(1, BigInteger.valueOf(sx.nextInt()));
    int x = sx.nextInt();

    System.out.println(beast(x - 1));
}

public static BigInteger beast(int n) {
    if (!storage.containsKey(n)) {
        BigInteger t = beast(n - 1);
        storage.put(n, t.multiply(t).add(beast(n - 2)));
    }
    return storage.get(n);
}