import java.util.ArrayList;
import java.util.Scanner;

/***************************************************
 *
 * @file: PrimeFactors.java
 * @date: Mar 17, 2013
 * @author: AaronW
 */

/**
 *
 * @author AaronW
 */
public class PrimeFactors {

    public PrimeFactors() {
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        long num;
        Scanner in = new Scanner(System.in);

        System.out.println("\n\n\nThis program finds the prime factors of a given number.\n");
        System.out.print("Please enter the number: ");
        num = in.nextInt();
        System.out.println("\nThe factors are: " + findFactors((double)num) + "\n");
    }

    public static ArrayList<Integer> findFactors(Double num) {
        ArrayList<Integer> factors = new ArrayList<Integer>();

        for (int x = 1; x <= num; x++) {
            System.out.println("Testing " + num + " % " + x + " = " + num % x);
            // First, let's see if a number is factor of your target number
            if (num % x == 0) {
                System.out.println(x + " is a factor");
                // Now that we know it's a factor, let's test to see if it's prime
                if (isPrime(x)) {
                    // If it's prime, add it to the ArrayList
                    System.out.println("And " + x + " is prime.");
                    factors.add(x);
                } else {
                    System.out.println("But " + x + " is not prime.");
                }
            } else {
                System.out.println(x + " is not a factor");
            }
        }

        return factors;
    }

    public static boolean isPrime(double num) {
        // Let's start by assuming everything is prime and try to prove that false
        // If we fall through the loop without proving it false, we have a prime
        boolean prime = true;

        for (int x = 2; x < num; x++) {
            // if our target number can be divided by any number between 1 and itself, it is not prime
            if (num % x == 0) {
                prime = false;
            }
        }

        return prime;
    }
}