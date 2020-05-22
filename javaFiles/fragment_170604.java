import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class Test {

    public static void main(String[] args) {

        try {
            BufferedReader myfis = new BufferedReader(new FileReader("D:\\myfis2.txt"));
            ArrayList<String> foundaz = new ArrayList<String>();

            String line;
            while ((line = myfis.readLine()) != null) {
                String delim = " ";
                String[] words = line.split(delim);

                for (String s : words) {                    
                    if (!s.isEmpty() && s != null) {
                        Pattern pi = Pattern.compile("[aA].*z");
                        Matcher ma = pi.matcher(s);

                        if (ma.find()) {
                           foundaz.add(s);
                        }
                    }
                }
            }

            if (!foundaz.isEmpty()) {
                System.out.println("The words that start with a and ends with z are:");
                for (String s : foundaz) {
                    System.out.println(s);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}