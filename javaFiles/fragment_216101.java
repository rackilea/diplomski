import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientServerTest2
{

    public static void main(String[] args) throws Exception
    {
        Thread serverThread = new Thread(new Server());
        serverThread.start();
        Thread clientThread = new Thread(new Client());
        clientThread.start();

        serverThread.join();
        clientThread.join();
    }

    private static class Server implements Runnable
    {
        @Override
        public void run()
        {
            ServerSocket serverSocket = null;
            try
            {
                serverSocket = new ServerSocket(1234);

                Socket clientSocket = null;
                clientSocket = serverSocket.accept();
                debug("Connected");

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String textFromClient = null;
                String textToClient = null;
                textFromClient = in.readLine(); // read the text from client
                debug("Read '" + textFromClient + "'");
                if ("A".equals(textFromClient))
                {
                    textToClient = "1111";
                }
                else if ("B".equals(textFromClient))
                {
                    textToClient = "2222\r\n3333";
                }

                debug("Writing '" + textToClient + "'");
                out.print(textToClient + "\r\n"); // send the response to client
                out.flush();
                out.close();
                in.close();
                clientSocket.close();
                serverSocket.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }

        private static void debug(String msg)
        {
            System.out.println("Server: " + msg);
        }
    }

    private static class Client implements Runnable
    {

        @Override
        public void run()
        {
            Socket socket = null;
            PrintWriter out = null;
            BufferedReader in = null;
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            try
            {
                socket = new Socket("localhost", 1234);
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                debug("Connected");

                String textToServer;

                textToServer = read.readLine();
                debug("Sending '" + textToServer + "'");
                out.print(textToServer + "\r\n"); // send to server
                out.flush();

                String serverResponse = null;
                while ((serverResponse = in.readLine()) != null)
                    debug(serverResponse); // read from server and print it.

                out.close();
                in.close();
                read.close();
                socket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private static void debug(String msg)
    {
        System.out.println("Client: " + msg);
    }
}