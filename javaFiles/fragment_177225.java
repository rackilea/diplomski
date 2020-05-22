import java.net.*;
import java.io.*;

public class SimpleClient {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter(args[args.length - 1]);

            BufferedWriter bw = new BufferedWriter(fw);
            try {
                Socket con = new Socket(args[0], Integer.parseInt(args[1]));

                PrintStream out = new PrintStream(con.getOutputStream());
                out.println("GET /search?q=" + args[2] + " HTTP/1.1");
                out.println("Host: www.google.com");
                out.println("");
                out.write(0); // mark end of message
                out.flush();

                InputStreamReader in = new InputStreamReader(
                        con.getInputStream());
                int c;
                while ((c = in.read()) != -1)
                    bw.write((char) c);    
                con.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}