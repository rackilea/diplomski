import java.util.Scanner;

public class Pregunta {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 0 to exit.");
        int input = scanner.nextInt();

        while ( input != 0 )
        {
            System.out.println( switchUsersInput(input));
            System.out.println("Press 0 to exit.");
            input = scanner.nextInt();
        }
        System.out.println("Finish.");
    }



    public static String switchUsersInput( int input )
    {
        switch (input)
        {
            case 1:
                return "Example";
            case 2:
                return "Example 2 I didn't get your get.example();";
            default:
                return "Chose something :)";
        }
    }

}