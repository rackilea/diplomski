public class Test {
    public static void main(String[] args) {
        int number = 750000; // starting number
        int nofn = 100; // number of primes to find
        int primecount = 0;
        int row = 0, col = 0;

        while (primecount < nofn) {
            if (isPrime(number)) {
                primecount++;
                if (col++ == 0)
                    System.out.print(String.format("%3d-->", ++row));
                System.out.print(String.format(" %6d", number));
                if (col == 10) {
                    System.out.println();
                    col = 0;
                }
            }
            number++;
        }
    }

    private static boolean isPrime(int num) {
        final int last = (int) Math.sqrt(num);
        for (int divisor = 2; divisor <= last; ++divisor) {
            if (num % divisor == 0)
                return false;
        }
        return true;
    }

}