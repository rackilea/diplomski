public class FibonacciSequence {

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            int num = (int) ((getY_1(i) - getY_2(i)) / Math.sqrt(5));
            if (isPrime(num)) {
                System.out.print("This is a prime : ");
            }
            System.out.println(num);
        }
    }

    public static double getY_1(int N) {
        return Math.pow((1 + Math.sqrt(5.0)) / 2.0, N);
    }

    public static double getY_2(int N) {
        return Math.pow((1 - Math.sqrt(5.0)) / 2.0, N);
    }

    public static boolean isPrime(int num) {
        if (num == 2 || num == 3)
            return true;

        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        int i = 5;
        int s = 2;

        while (i * i <= num) {
            if (num % i == 0) {
                return false;
            }

            i += s;
            s = 6 - s;
        }
        return true;
    }
}