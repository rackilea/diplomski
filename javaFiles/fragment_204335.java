import java.io.*;
import java.util.*;

public class Assignment4
{
    public static void main(String[] args) throws IOException
    {
        Map<String, String> morseCodes = new HashMap<String, String>();
        File file1 = new File ("morsecode.txt");
        Scanner in = new Scanner(file1);  

        while (in.hasNext())
        {
            String letter = in.next();          
            String code = in.next();   
            morseCodes.put(code, letter);
        }

        File morseCode = new File("message.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(morseCode));
        String line;

        while ((line = bufferedReader.readLine()) != null)
        {
            String letter = "";

            for (String morseLetter: line.split(" "))
            {
                letter = morseCodes.get(morseLetter);
                System.out.print(letter);
            }

            if (letter.equals(".")) {
                // Insert a new line after a period.
                System.out.println();
            } else {
                // Insert a space between words.
                System.out.print(' ');
            }
        }
    }
}