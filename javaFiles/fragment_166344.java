import java.io.IOException;

import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket connection;

    // wait For Connection,then display connection information
    private void waitforConnection() {
        System.out.println("wait for Someone to Connect.....\n");
        try {
            connection = server.accept();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("error In Acceptance of Server!!\n...");
        }
        System.out.println(("Connection      Established" + connection
                .getInetAddress().getHostName()));

    }

    // Setting Up Streams to Get Input and Output

    private void setupStreams() {
        try {
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input = new ObjectInputStream(connection.getInputStream());
            System.out.println("Your Streams are Perfectly Working...");

        } catch (IOException e) {
            // TODO Auto-generated catch block

            System.err.println("Error Found! in Streaming Connectionos");
            e.printStackTrace();
        }
    }

    // While Chatting Method....!!//
    private void whileChatting() throws IOException {
        String Message = "You are now Connected!!\n";
        sendMessage(Message);

        // abletoType(true);
        do {
            try {
                Message = (String) input.readObject();
                System.out.println("\n" + Message);
            } catch (ClassNotFoundException e) {
                System.out.println("wtf---Fuck\n YOu\n Bloody\n HAcker!!!\n");
            }

        } while (!Message.equals("CLIENT--END"));

    }

    // Closing All Streams and Socket after you are done//
    private void closeCrap() {
        System.out.println("\nClosing Connection...........Bye Bye\n");
        // abletoType(false);
        try {
            output.close();
            input.close();
            connection.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Couldn't Close Connections!");
        }

    }

    // Sending Messages to Client
    private void sendMessage(String message) {
        try {

            output.writeObject("SERVER--- " + message);

            output.flush();
            System.out.println("\nServer- " + message);

        } catch (IOException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
            System.out.println("Dude I cant Send yeaah..");
        }

    }

    // Setting up the Server

    public void runningserver() {
        try {
            server = new ServerSocket(4444, 100);
            while (true) {
                try {
                    // connect and Have connection
                    waitforConnection();
                    setupStreams();
                    whileChatting();
                } finally {
                    closeCrap();
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}