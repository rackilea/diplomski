import java.util.Scanner;
public class NumChecker {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number between 1 and 10: ");
        int num1 = in.nextInt();
        while (num1 < 1 || num1 > 10) {
            System.out.print("Invalid number, enter another one: ");
            num1 = in.nextInt();
        }
        System.out.println("Input = " + num1);
     }
}