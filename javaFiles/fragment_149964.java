package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        pyramid();
    }

    public static void pyramid() {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter a number between 1 and 20");
        int num = scan.nextInt();

        for (int i = 0; i < num + 1; i++) {
            for (int j = 0; j < num - i; j++) {
                System.out.print("  ");
            }
            for (int j = i; j > 0; --j) {
                System.out.printf("%d ", j);
            }
            for (int j = 2; j <= i; ++j) {
                System.out.printf("%d ", j);
            }
            System.out.println();
        }
    }
}