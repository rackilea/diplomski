import java.lang.System;
import java.util.Scanner;

public class Java{
 public static void main(String args[])
 {

    int result = 0;

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number");
    result = sc.nextInt();
    System.out.println("Enter operation");
    System.out.println("1.+");
    System.out.println("2.-");
    System.out.println("3.*");
    System.out.println("4./");
    System.out.println("5.=");
    int operation = sc.nextInt();

    while (operation != 5) {
        System.out.println("Enter next number");
        int number = sc.nextInt();

        switch (operation) {
            case 1:
                result += number;
                System.out.println("result= " + result);
                break;
            case 2:
                result -= number;
                System.out.println("result= " + result);
                break;
            case 3:
                result *= number;
                System.out.println("result= " + result);
                break;
            case 4:
                result /= number;
                System.out.println("result= " + result);
                break;

        }
        System.out.println(result);
        System.out.println("Enter operation");
        operation = sc.nextInt();

    }
 }
}