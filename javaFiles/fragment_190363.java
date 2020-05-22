public class PrimeNumber {

    public static void main(String[] args) {

        ....

        for (int k = num1; k <= num2; k++) {
            if (isPrime(k)) {
                System.out.println(k);
            }
        }
    }

    private static boolean isPrime(int k) {
        if (k < 2) {
            return false;
        } else {
            for (int i = 2; i < k; i++) {
                if (k % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}