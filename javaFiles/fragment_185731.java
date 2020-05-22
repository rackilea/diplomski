import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class MainTest {
    public static void main(String[] args) {

        Scanner kw = new Scanner(System.in);
        double kwUsed = 0;

        // Verify if KW is valid
        try {

            // KW used data entry
            System.out.println("Please enter KW used: ");
            kwUsed = kw.nextDouble();
            System.out.println("KW entry valid");
        } catch (Exception error) {
            System.out.println("Invalid entry");
            System.out.println(error);
        }

        // Date entry will be calculated by how much KW user enters
        String input;
        System.out.println("Enter input case");
        input = kw.next();

        switch (input) {
        case "2/15/13":
            double quarter1 = kwUsed * 0.10;
            break;
        case "4/15/13":
            double quarter2 = kwUsed * 0.12;
            break;
        case "8/15/13":
            double quarter3 = kwUsed * 0.15;
            break;
        case "11/15/13":
            double quarter4 = kwUsed * 0.15;
            break;
        default:
            System.out.println("Invalid date");

        }
            //handle your quarter1-4 here
    }
}