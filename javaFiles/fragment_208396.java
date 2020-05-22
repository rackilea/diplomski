package Main;
import java.util.Scanner;

public class Assignment {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String[] names = new String[10];

        int index = 0;
        while (index<10) {
            index++;
            System.out.print("Home team name: ");
            names[index] = keyboard.nextLine();

            System.out.print("Away team name: ");
            names[index] = keyboard.nextLine();

            System.out.print("Enter home score: ");
            names[index] = keyboard.nextLine();

            System.out.print("Enter away score: ");
            names[index] = keyboard.nextLine();

            System.out.print("If you would like to quit type exit: ");
            if ("exit".equalsIgnoreCase(keyboard.nextLine())) {
                index = 10;
                keyboard.close();
            }
        }
    }
}