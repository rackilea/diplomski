import java.io.*;
import java.util.*;

public class UniqueName {

    public static void main(String args[]) throws IOException{

        Scanner input = new Scanner(new FileReader("Names.txt"));
        Set<String> uniqueNames = new HashSet<String>();

        while (input.hasNextLine()) {
        String line = input.nextLine();

           String str [] = line.split((" "));
              for ( int i = 0; i <str.length ; i ++) {
                if (str [i].length() > 0) {
                  wordcount ++; 

                }
                uniqueNames.add(str[i]);

              }

        }

        System.out.println(wordcount);
        System.out.println(uniqueNames);
    }
}