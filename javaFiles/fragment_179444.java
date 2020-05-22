package com.stackoverflow.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class xzip_code {

    public static void main(String[] args) {
        System.out.println("Enter 5 Digits");

        boolean isError = true;
        while (isError) {
            try {
                Bounds(Program());
            } catch (IllegalArgumentException ex) {
                System.out.println("Enter 5 Digits");
                continue;
            } catch (InputMismatchException ex) {
                System.out.println("Enter Numbers");
                continue;
            }
            isError = false;
        }
    }

    public static void Bounds(String answer) {
        int length = answer.length();

        if (length < 5 || length > 5) {
            throw new IllegalArgumentException("Enter 5 Digits");

        }
        char a = answer.charAt(0);
        char b = answer.charAt(1);
        char c = answer.charAt(2);
        char d = answer.charAt(3);
        char e = answer.charAt(4);

        if (!(Character.isDigit(a) && Character.isDigit(b) && Character.isDigit(c) && Character.isDigit(d)
                && Character.isDigit(e))) {
            throw new InputMismatchException("Enter Numbers");
        }

    }

    public static String Program() {
        Scanner userInput = new Scanner(System.in);
        String x = userInput.next();
        System.out.println(x);
        return x;

    }

}