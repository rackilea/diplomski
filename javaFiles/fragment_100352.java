import static java.lang.System.out;
import java.util.Scanner;

class MyClass {
    public static void main(String args[]) {

        double a, b, c, d, e, f;

        Scanner input = new Scanner(System.in);
        out.println(" Please enter the first number: ");
        a = input.nextDouble();
        out.println("Please enter the second number: ");
        b = input.nextDouble();
        out.println("Please enter the third number : ");
        c = input.nextDouble();
        out.println("Please enter in fourth number : ");
        d = input.nextDouble();
        out.println(" Please enter in fifth number : ");
        e = input.nextDouble();

        double sum = a + b + c + d + e;
        out.println("Sum is : " + sum);
    }
}