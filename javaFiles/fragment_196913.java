public class EvenOrOdd {
public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);

    System.out
            .println("Welcome to my program that checks if a number is even or odd.");
    boolean enterLoop = true;
    while (enterLoop) {
        System.out.println();
        System.out.print("Please type number in a number ['q' to quit]: ");

        String scannerinput = myScanner.nextLine();
        if (scannerinput.equals("q")) {
            enterLoop = false;
        } else {
            checkNumber(scannerinput);
        }

    }
}

private static void checkNumber(String scannerinput) {
    try {
        int number = Integer.parseInt(scannerinput);
        if (number % 2 == 0) {
            System.out.println(number + " is Even.");
        } else {
            System.out.println(number + " is Odd.");
        }
    } catch (Exception e) {
        System.out.println("No Number!");
    }
}