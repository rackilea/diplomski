package teststuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Btest {

 public static void main(String args[])
     {
     try
         {
         File file = new File("test.txt");
         BufferedReader reader = new BufferedReader(new FileReader(file));
         String line = "", oldtext = "", fivthLine = "";
         int x=0;
         while((line = reader.readLine()) != null)
             {
             oldtext += line + "\r\n";
             if(x == 4)
             {
                 fivthLine = line;
             }
             x++;
         }
         reader.close();

         String newtext = oldtext.replaceAll(fivthLine, "blah blah blah");

         FileWriter writer = new FileWriter("test.txt");
         writer.write(newtext);writer.close();
     }
     catch (IOException ioe)
         {
         ioe.printStackTrace();
     }
 }
}