import java.util.*;

public class RecursiveAsterisks {
    // Global Variables
    private static Scanner in = new Scanner(System.in); 
    private static Boolean go = true;
    private static int num;
    private static String answer;
    private static String s = "*";

    public static void main(String[] args) {    
        // Error catching structure 
        do {
            try {
                // Take input
                System.out.print("Enter a number > 1: ");
                num = in.nextInt();

                // Check to make sure num>1
                if (num <= 1) throw new Exception();

                // Call the method 
                printAsterisk(num);
                s = "*"; // reset string

                // Ask if the user wants to repeat
                System.out.print("Enter 'y' to repeat or 'n' to stop: ");
                answer = in.next().toLowerCase();

                // Check to see if we repeat
                if (answer.equals("n")) go = false; 
                else if (answer.equals("y")) go = true;
                else {
                    System.out.println("Invalid input, program terminated.");
                    break; // stops the program
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input try again!");
                in.next(); // discards old token 
            }
            catch (Exception e) {
                System.out.println("Number is less than or equal to 1! Try 
again!");
            }
        }while(go);
    }

    // Recursive Method
    public static void printAsterisk(int n) {
        // Base case
        if (n == 0) return;

        // Recursive Call
        System.out.println(s);
        s += '*'; // concatenate string 
        printAsterisk(n-1);
        System.out.println(s.substring(n));
    }
}