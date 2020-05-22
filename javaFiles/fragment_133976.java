import java.util.Scanner;

public class TwoDimensionalArray { 

     public static void TwoDimensionalArray_M(){

         Scanner input = new Scanner(System.in);

         int numNames=3;

         String[][] newString = new String[numNames][2];

         for (int i=0; i<newString[numLastNames].Length; i++)
         {
              System.out.println("Input first name for index " + i + ":");
              newString[i][0] = input.nextLine();
              System.out.println("Input last name for index " + i + ":");
              newString[i][1] = input.nextLine();
         }

         System.out.println("All values have been inputted.");
     }
}