import java.util.Scanner;

public class NameRearranged {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a name like D2L shows them: ");
        String entireLine = keyboard.nextLine();

        String[] fml = entireLine.split(","); //seperate the string by commas

        String[] newName = fml[0].split(" "); //seperates the first element into 
                                              //a new array by spaces to hold first and middle name

        //this will display the last name (fml[1]) then the first element in 
        //newName array and finally the first char of the second element in
        //newName array to get your desired results.
        String newLine = fml[1] + ", " + newName[0] + " "+newName[1].charAt(0)+".";

        System.out.println(newLine);


    }

}