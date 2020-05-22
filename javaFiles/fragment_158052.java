public class Tester {

private static Scanner keyboard;

/**
 * @param args
 */
public static void main(String[] args) {
    keyboard = new Scanner(System.in);

    out.println("This program will copy whatever you type.");
    out.println("Please enter a phrase:");

    String inputPhrase = keyboard.nextLine();
    out.println();
    out.println(inputPhrase);
}