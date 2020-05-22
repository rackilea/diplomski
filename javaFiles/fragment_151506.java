import java.net.*;
import java.io.*;
import java.util.*;

public class DataURL {
    public static void main(String[] args) throws Exception {
        URL yahoo = new URL("http://www.yahoo.com/");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                yahoo.openStream()));

        String inputLine;

        int i=5; /* number lines */
        List<String> lines = new ArrayList<String>();
        while (i>0 && (inputLine = in.readLine()) != null) {
            lines.add(inputLine);
            i--;
        }   
        in.close();

        for (i=lines.size()-1; i >= 0; i--) {
            System.out.println("Line " + i + ": " + lines.get(i));
        }   
    }   
}