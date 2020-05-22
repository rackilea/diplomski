import java.util.Scanner;

public class E7L6 {
    public static void main(String[] args) {
        int num1, num2;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Type two numbers:");
        num1 = keyboard.nextInt();
        num2 = keyboard.nextInt();

        if (num1 < num2) {
            int counter = num1;
            while (counter <= num2) {
                System.out.print(counter + " ");
                counter = counter + 1;
            }
        } else {
            System.out
                    .print("Error: the first number must be smaller than the second");
        }
    }
}