public class Factorial {

    private static Map<Integer, Long> memo = new ConcurrentHashMap<Integer, Long>();

    public static void main(String[] args) {
        for (int i = 0; i < 11; ++i) {
            System.out.println(String.format("n: %d n!: %d", i, factorial(i)));
        }
    }
    public static long factorial(int n) {
        long value = 1L;
        if (n > 1) {
            if (memo.containsKey(n)) {
                value = memo.get(n);
            } else {
                for (int i = 1; i <= n; ++i) {
                    value *= i;
                }
                memo.put(n, value);
            }
        }
        return value;
    }
}