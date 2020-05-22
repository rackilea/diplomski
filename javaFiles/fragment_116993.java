import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a price: ");
        double number = input.nextDouble();
        while (number < 0 ) {
            System.out.print("Sorry, but your price must be a positive decimal. Enter a price:  ");
            number = input.nextDouble();
        }
        System.out.println("Your price is " + number);
    }
}