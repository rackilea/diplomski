import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {
    public static void main(String[] args) throws IOException {
        Test test = new Test();
        test.startServer();
        test.makeConnection();
    }

    public void startServer() throws IOException {
        final ServerSocket listener = new ServerSocket(60001);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String command = null;
                    while (true) {
                        Socket socket = listener.accept();
                        System.out.println("Got a connection from: " + socket.getLocalPort());
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        command = in.readLine();
                        System.out.println("GOT HERE");
                        if (command != null && !"".equals(command)) {
                            if ("connection".equals(command)) {
                                Writer writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                                writer.write("success\n");
                                writer.flush();
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    public void makeConnection() {
        System.out.println("Making Connection");;
        try {
            Socket socket = new Socket("localhost", 60001);
            Writer writer = new PrintWriter(socket.getOutputStream(), true);
            writer.write("connection\n");
            writer.flush();
            BufferedReader socketRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str;
            while ((str = socketRead.readLine()) != null) {
                if ("success".equals(str)) {
                    System.out.println("Successfully saved all hosts to: "); //+ listOfHosts.get(i));
                    socketRead.close();
                    socket.close();
                    //iStream.close();
                    writer.close();
                }
            }
        }catch (Exception e) {
             System.out.println(e.getMessage());
        }
    }

}