import java.net.*;
import java.io.*;

public class URLReader {
    public static void main(String[] args) throws Exception {
        // Here you need add copy file program which will copy file from c:/abc/abc.txt to your web project folder
        URL oracle = new URL("http://www.demo.com/abc.txt");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}