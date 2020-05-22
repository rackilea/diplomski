import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep 
{
    public static void main(String[] args) 
    {
        // Initialize and Declare Variables
        Pattern pattern = Pattern.compile("[Pp]attern");
        String sentences[] = new String[3];
        Scanner scanner = new Scanner(System.in);
        int foundCount = 1;


        // Present A Title For The End User
        System.out.println("This Program Will Catch Sentences With The Term Pattern.\n");


        // Read The Inputs From The Users
        for (int i = 0; i < sentences.length; i++)
        {
            System.out.print("Enter Sentence #" + (i+1) + ":  ");
            sentences[i] = scanner.nextLine();
        }


        // Line Break
        System.out.println();


        // Write Sentences That Include The Term Pattern
        for (int i = 0; i < sentences.length; i++) 
        { 
            Matcher matcher = pattern.matcher(sentences[i]);
            if (matcher.find())
            {
                System.out.println(foundCount + ")  " + sentences[i]);
                foundCount++;
            }
        }
    }
}