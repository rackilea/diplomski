package pkg2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Write a number: ");
        int first = reader.nextInt();
        System.out.println("Write another number: ");
        int second = reader.nextInt();
        System.out.println("Write an operator: ");
        char operator = reader.next().charAt(0);
        if(operator == '+') {
            System.out.println(first + second);
        }
        else if(operator == '-') {
            System.out.println(first - second);
        }
        else if(operator == '*') {
            System.out.println(first * second);
        }
        else if(operator == '/') {
            System.out.println(first / second);
        }
    }
}