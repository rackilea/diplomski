import java.util.Scanner;

public class structuredcontrols {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double sum = 0;
        double sum2 = 0;
        double sum3 = 0;
        int number = 0;
        int quantity;

        while (number != -1) {

            System.out.print("Enter product number: ");
            number = input.nextInt();

            if (number == -1)
                break;
            System.out.print("Enter quantity number: ");
            quantity = input.nextInt();

            switch (number)

            {
            case 1:
                sum += 2.98 * quantity;
                break;
            case 2:
                sum2 += 4.50 * quantity;
                break;
            case 3:
                sum3 += 9.98 * quantity;
                break;
            }
        }
        System.out.println("Total value of product 1 is: " + sum);
        System.out.println("Total value of product 2 is: " + sum2);
        System.out.println("Total value of product 3 is: " + sum3);
    }

}