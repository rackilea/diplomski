package test;

import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

public class Primes_below_N {

    static Vector<Integer> numbers = new Vector<Integer>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));

    public static void main(String[] args) throws IOException {
        System.out.print("Please enter a number: ");
        int LIMIT = Integer.parseInt(br.readLine());
        populate(LIMIT);
        calculatePrimes(LIMIT);
        print(numbers);

    }

    // populate a 'numbers' with a numbers upto limit
    public static void populate(int limit) {
        for (int i = 1; i <= limit; i++) {
            numbers.add(i);
        }
    }

    // calculate prime numbers
    public static void calculatePrimes(int limit) {
        int p = 2;
        int nextPrime = 1;
        while (Math.pow(p, 2) < limit) {
            for (int i = 0; i < numbers.size(); ++i) {

                // CHANGE 1 - IF block change
                if (numbers.get(i) % p == 0 && numbers.get(i) != p) {
                    numbers.remove(i);
                }
            }

            // CHANGE 2 - Reorder
            nextPrime += 1; 
            p = numbers.get(nextPrime);

        }
    }

    public static void print(Vector<Integer> list) {
        for (int i : list) {
            System.out.print(i + ", "); // Changed for single line printing
        }
    }

}