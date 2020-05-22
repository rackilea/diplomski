package com.mysuper.sdk;

// Public class.
public class PublicAPI {
    // Main method.
    public static void main(String... args) {
        int[] numbers = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            numbers[i] = Integer.parseInt(args[i]);
        }

        System.out.println(new Controller().translateNumbers(numbers));
    }
}