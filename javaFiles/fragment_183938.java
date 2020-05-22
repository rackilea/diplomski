import java.io.*;
import java.net.*;

public class SendPost {
    public static void main(String[] args) {
        try {
            String post_request = "POST /login HTTP/1.1\r\nHost: localhost:1234\r\nContent-Length: 41\r\nContent-Type: application/x-www-form-urlencoded\r\n\r\nusername=bob%40test.com&password=i+forget";

            Socket s = new Socket("localhost", 1234);
            DataOutputStream out = new DataOutputStream(s.getOutputStream());           
            out.writeBytes(post_request);          
            s.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}