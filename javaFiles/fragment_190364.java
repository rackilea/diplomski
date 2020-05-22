public class PrimeNumber {

    public static void main(String[] args) {

        ....

        for (int k = num1; k <= num2; k++) {
            boolean isPrime = true;

            if (k < 2) {
                isPrime = false;
            } else {
                for (int i = 2; i < k; i++) {
                    if (k % i == 0) {
                        isPrime = false;
                    }
                }
            }

            if (isPrime) {
                System.out.println(k);
            }
        }
    }

}