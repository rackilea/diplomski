import java.util.Scanner;

public class People {
   static final Scanner keyboard = new Scanner(System.in);
   static final int MAX = 50;
   static final String[] LABLES = {"infants", "children", "teens", "adults"};

   public static void main(String[] args) {
       int[] counts = new int[4];
       for (int i = 0; i < MAX; i++) {
           System.out.println("Please enter value:");
           int current = keyboard.nextInt(); //problem input: "abc" -> java.util.InputMismatchException
           while (current > 4 || current < 1) {//checks range
               System.out.println("Please enter a valid value (between 1 and 4):");                    
               current = keyboard.nextInt();//...and repeat
           }
           counts[current - 1]++;//increment counter, "current - 1", since 0-based array and 1-based input
       }
       System.out.println("Evaluation finished!");
       for (int i = 0; i < 4; i++) {//print the output
           System.out.println(LABLES[i] + ": " + counts[i]);
       }
   }
}