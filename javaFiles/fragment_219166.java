package triangle;

import java.util.Scanner;

public class triangle {

    public static void main(String[] args){ 
         //explaining what the program is going to do 
        System.out.println("You will be able to enter 3 angles to equal the sum of a triangle,\n");
        System.out.println("this automated program will tell you if the angle you entered is isoceles, eqilateral or scalene");
        //creating input 1,2,3 for user

        Scanner s = new Scanner(System.in);  // Reading from System.in

        String line;
        int [] angles = new int [3];
        int count = 0;

        do {
            System.out.print("Enter angle degree number " + (count+1) + ": ");
            line = s.nextLine();
            while (true ) {
                try {
                    angles[count] = Integer.parseInt(line);
                    System.out.println("You entered " + angles[count]);
                    count++;
                    break;
                } catch (NumberFormatException e ) {
                    System.out.println("Invalid number: try again: ");
                    line = s.nextLine();
                }
            }
        } while (count < 3);


    }
}