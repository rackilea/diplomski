import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MiniPbxManServer extends Thread {
    private final int PORT = 2222;    
    public static void main(String[] args) {
        MiniPbxManServer gtp = new MiniPbxManServer();
        gtp.start();
    }    
    public void run() {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("MiniServer active "+PORT);
            boolean shudown = true;
            while (shudown) {               
                Socket socket = server.accept();                
                InputStream is = socket.getInputStream();
                PrintWriter out = new PrintWriter(socket.getOutputStream());            
                BufferedReader in = new BufferedReader(new InputStreamReader(is));              
                String line;
                line = in.readLine();
                String auxLine = line;
                line = "";
                // looks for post data
                int postDataI = -1;
                while ((line = in.readLine()) != null && (line.length() != 0)) {
                    System.out.println(line);
                    if (line.indexOf("Content-Length:") > -1) {
                        postDataI = new Integer(line
                                .substring(
                                        line.indexOf("Content-Length:") + 16,
                                        line.length())).intValue();
                    }
                }
                String postData = "";
                for (int i = 0; i < postDataI; i++) {
                    int intParser = in.read();
                    postData += (char) intParser;
                }                               
                out.println("HTTP/1.0 200 OK");
                out.println("Content-Type: text/html; charset=utf-8");
                out.println("Server: MINISERVER");
                // this blank line signals the end of the headers
                out.println("");
                // Send the HTML page               
                out.println("<H1>Welcome to the Mini PbxMan server</H1>");
                out.println("<H2>GET->"+auxLine+ "</H2>");        
                out.println("<H2>Post->"+postData+ "</H2>");
                out.println("<form name=\"input\" action=\"imback\" method=\"post\">");
                out.println("Username: <input type=\"text\" name=\"user\"><input type=\"submit\" value=\"Submit\"></form>");                 
                //if your get parameter contains shutdown it will shutdown
                if(auxLine.indexOf("?shutdown")>-1){
                    shudown = false;
                }
                out.close();
                socket.close();
            }
            server.close();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}