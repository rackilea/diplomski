import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean repeat = true;
        while (repeat) {
            // declare variables to hold the base and height
            double base;
            double height;
            // Variables created. move on
            System.out.print("Enter the triangle's base (enter 0 to exit): ");
            base = sc.nextDouble();
            if (base == 0) {
                repeat = false;
                break;
            }
            // Base has been declared and filled in
            System.out.print("Enter the triangle's height (enter 0 to exit): ");
            height = sc.nextDouble();
            if (height == 0) {
                repeat = false;
                break;
            }
            // Both variables are filled in
            double preArea = base * height;
            // now we need to divide by 2
            double Area = preArea / 2;
            // There we go. All variables are done, area has been calculated.
            System.out.println("The area of your triangle is: " + Area);

            if (Area <= 100) {
                System.out.println("Triangle's area is small");
            }

            if (Area <= 300) {
                System.out.println("Triangles size is medium");

            }
            if (Area >= 300) {
                System.out.println("Triangle's area is big");
            }

            else {

            }

        }
        System.out.println("Bye bye");
}
}