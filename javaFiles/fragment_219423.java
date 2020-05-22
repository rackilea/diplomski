package com.company;

import java.util.Scanner;

public class Chef_prime_palindromes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long num = input.nextLong();
        isPalindrom(num + 1);
    }

    public static boolean isPrime(long num) {
        long i;
        for (i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void isPalindrom(long num) {
        for (; ; ) {
            if (isPalindrome(num)) {
                if (isPrime(num)) {
                    System.out.println(num);
                    System.exit(0);
                } else {
                    num++;
                }
            } else {
                num++;
            }
        }
    }

    public static boolean isPalindrome(long num) {
        String string = String.valueOf(num);
        return string.equals(new StringBuilder(string).reverse().toString());
    }
}