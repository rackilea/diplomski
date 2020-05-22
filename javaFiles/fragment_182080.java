import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep 
{
    public static void main(String[] args) 
    {
        Pattern pattern = Pattern.compile("[Pp]attern");
        String sentences[] = new String[3];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter some sentences: ");

        for (int i = 0; i < sentences.length; i++) 
            sentences[i] = scanner.nextLine();

        for (int i = 0; i < sentences.length; i++) 
        { 
            Matcher matcher = pattern.matcher(sentences[i]);
            if (matcher.find()) 
                System.out.println(sentences[i]);
        }
    }
}