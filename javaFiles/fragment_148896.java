import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jtech
 */
public class ReplaceWithIndexes
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = null;
        boolean endMatched = false;
        int startIndex[] = {0,4,8};
        int endIndex[] = {3,7,10};
        int c = 0, c1 = 0, c2 = 0, largestVal_start = 0, largestVal_end = 0, lineCount = 0;
        String line = null, newString = "";
        String[] VALUES = new String[] {"Sys","Jav","Tes"};  

        br = new BufferedReader(new FileReader("C:\\Users\\jtech\\Documents\\NetBeansProjects\\HelpOthers\\src\\textFiles\\AnotherFile.txt"));

        for (int i = 0; i < startIndex.length; i++)
        {
            if (startIndex[i] > largestVal_start)
            {
                largestVal_start = startIndex[i];
            }
        }

        for (int i = 0; i < endIndex.length; i++)
        {
            if (endIndex[i] > largestVal_end)
            {
                largestVal_end = endIndex[i];
            }
        }       


            while ((line = br.readLine()) != null)   
            {

                StringBuilder buf = new StringBuilder(line);
                          // Print the content on the console
                System.out.println(line);
                lineCount++;

                    while (c <= largestVal_start)
                    {                       
                       while (c1 <= largestVal_end)
                       {                           
                           if (startIndex[0] == c && endIndex[0] == c1)
                           {
                             buf.replace(startIndex[0], endIndex[0], VALUES[c2]);
                             newString = buf.toString();
                             endMatched = true;
                           }
                           else if (startIndex[1] == c && endIndex[1] == c1)
                           {
                             buf.replace(startIndex[1], endIndex[1], VALUES[c2]);
                             newString = buf.toString();
                             endMatched = true;
                           }
                           else if (startIndex[2] == c && endIndex[2] == c1)
                           {
                             buf.replace(startIndex[2], endIndex[2], VALUES[c2]);
                             newString = buf.toString();
                             endMatched = true;
                           }

                         c1++;
                       }

                      for (int i = 0; i < startIndex.length; i++)
                      {
                        if (c == startIndex[i])
                        {
                            c2++;
                        }

                      }

                      if (endMatched == true || ((c1 <= largestVal_end) == false) )
                      {
                          c1 = 0;
                          endMatched = false;
                      }

                      c++;

                    }

                if (lineCount <= 1)
                {
                  System.out.println("Updated line: " + newString);
                }

            }

    }
}