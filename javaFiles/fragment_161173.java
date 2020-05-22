import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.io.PrintWriter;
    import java.net.InetAddress;
    import java.net.Socket;

public class GateControl {
    public static void main(String []args) {
        try {
            // "192.168.1.177" is a IP of Server
            Socket s = new Socket("192.168.1.177", 80); 
            InetAddress add = s.getInetAddress();
            System.out.println("Connected to " + add);

            PrintWriter pw = new PrintWriter(s.getOutputStream());
            // "?butonon" is a content which you send to server
            pw.println("GET /?buttonon HTTP/1.1");
            pw.println("");
            pw.println("");
            pw.flush();
            System.out.println("Request sent");

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println(br.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}