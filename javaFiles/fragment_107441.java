import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class RevWords6
{
    public static void main(String[] args) throws IOException
    {   
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt"), "UTF-8"));                

        String lines = br.readLine();
        ArrayList<String> buffer = new ArrayList<String>();

        //while the data is not null
        while(lines != null)
        {   
            //String words[] = lines.split(" ");

            //track formatting
            if(lines != null)
            {   
                buffer.add("\n");

                StringBuilder str = new StringBuilder();
                String[] splitStr = lines.split(" ");
                for (int i = splitStr.length; i > 0; i--) {
                    str.append(splitStr[i - 1]).append(" ");
                }

                buffer.add(str.toString());  //I wanted to put the words array in here instead of "lines" but didn't know how
            }

            lines=br.readLine();
        }

        //reads lines backwards from ArrayList buffer but wanted to read words from end-to-beginning
        for(int i = buffer.size()-1; i>=0; i--)
        {
            System.out.print(buffer.get(i));
        }

        br.close();
    }
}