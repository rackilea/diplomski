import java.util.Scanner;

    public class SubstringCount
    {
         public static void main(String[] args)
         { 
             Scanner scan = new Scanner(System.in);
             System.out.println("Enter a word longer than 4 characters, and press q to quit");
             int count = 0;
             while (scan.hasNextLine())
             {
                String word = scan.next();
                if (word.contains("Stir"))
                {
                  System.out.println("Enter a word longer than 4 characters, and press q to quit");
                  count++;
                }
                else if (word.equals("q"))
                {
                  System.out.println("You have " + count + ( "words with 'Stir' in them"));
                  System.out.println("Enter a word longer than 4 characters, and press q to quit");
                }   
                else
                {
                  System.out.println("Enter a word longer than 4 characters, and press q to quit");
                }
             } //end of while
        }      //end of main
    }          //end of class