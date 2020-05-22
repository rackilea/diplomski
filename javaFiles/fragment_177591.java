import java.util.Scanner

public class EuroShoe {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int i = 

        double footLength, euroSize;

        System.out.println("EUROPEAN SHOE SIZE");
        System.out.println("Enter the length of your foot in inches:");

        // The statement below calls the "scanner" object to get the user input of value "double"
        footLength = scanner.nextDouble();

        euroSize = (((footLength - 9) * 3 / 2) + 15);
        System.out.println("Your European shoe size is " + euroSize);
    }
}