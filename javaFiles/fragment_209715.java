import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class BufferedReaderExample {

    public static void main(String[] args) {

try (BufferedReader br = new BufferedReader(new FileReader("testing.txt")))
        {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                String[] parts = sCurrentLine.split(" ");
                System.out.println(Arrays.toString(parts));
                List<String> splitNames = new ArrayList<>();
                for (String name : parts) {
                splitNames.addAll(Arrays.asList(name.split(",")));
            }
                for (String splitName : splitNames) {
                     System.out.println(splitName);
               }
         }
        } catch (IOException e) {
            e.printStackTrace();
        } 

    }
}