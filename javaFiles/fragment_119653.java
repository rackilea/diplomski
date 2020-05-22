public class PrimeNumbers {

public static void main(String args[]) {
    int i, j;

    for (i = 2; i <= 100; i++) {
        boolean prime = true;
        for (j = 2; j < i; j++) {
            if (i % j == 0) {
                prime = false;
                j=i;
            }
        }
        if (prime) {
            System.out.println(i + " is prime");
        }
    }
}