public class Fibonacci {

    public static void main(String[] args) {
        IntStream stream = IntStream.generate(new FibonacciSupplier());
        stream.limit(20).forEach(System.out::println);
    }

    private static class FibonacciSupplier implements IntSupplier {

        int current = 1;
        int previous = 0;

        @Override
        public int getAsInt() {
            int result = current;
            current = previous + current;
            previous = result;
            return result;
        }
    }
}