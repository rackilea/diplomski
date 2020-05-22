import java.net.*;
import java.io.*;

public class MyClass {

public static void main(String args[]) {
    try { 
        String str = "https://www.jdoodle.com/online-ja:va-compiler"; 
        String escapedStr = URLEncoder.encode(str, "UTF-8");
        System.out.println(escapedStr);
        String uriPath = new java.net.URI(escapedStr).getPath();
        System.out.println(uriPath);

    } catch (URISyntaxException |  UnsupportedEncodingException e) { 
        e.printStackTrace(); // just for the sake of this example, this should be logged properly
    }
}