package tempConverter;
import java.util.Scanner;

public class TempConverter {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the Temperature that is in Fahrenheit: ");
        int f = input.nextInt();
        double c = (f - 32) * 5 / 9;
        System.out.format("%.2f%n", c);
    }
}