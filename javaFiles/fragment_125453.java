import java.util.Scanner;

public class CountOccurence {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int num1 = sc.nextInt();
        System.out.println("Enter a list of positive numbers\nEnter -1 to indicate end:");
        int count = 0;
        int input = 0;
        while (input != -1) {
            input = sc.nextInt();
            if (input == num1) {
                count++;
            }
        }
        System.out.println("Your number occurs " + count + " times");
    }
}