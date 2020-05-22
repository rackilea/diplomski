import java.util.Scanner;

public class Program0 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("'A' to enter a number. 'Q' to quit");

        String line = reader.nextLine();
        String[] words = line.split(" ");

        if (words.length > 0 && words[0].equals("A")) {
            //if array is full System.out.println("The list is full!");
            // => I don't understand this part

            //else
            for(int i = 1; i<words.length; i++){
                int integer = Integer.parseInt(words[i]);
                System.out.println("Integer " + integer + " has been added to the list");

                //do your stuff here
            }
        }
        else if (words.length > 0 && words[0].equals("Q")) {
            System.out.println("List of integers: ");

            System.out.println("Average of all integers in the list: ");

        }
        else{
            System.out.println("Invalid Action");

        }
        reader.close();
    }

}