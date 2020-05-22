import java.util.Scanner;

public class InputTest {

    public static void main(String[] args) {

        //Now using the readIntFromConsole()

        int myNumber = readIntFromConsole();
        System.out.println(myNumber);
    }

    public static int readIntFromConsole() {
        System.out.print("Enter an integer value....");
        Scanner s = new Scanner(System.in);
        int number = s.nextInt();
        return number;
    }

}