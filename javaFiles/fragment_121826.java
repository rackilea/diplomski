import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

public class Client implements Runnable {

    private Socket clientSocket;

    private DataOutputStream out; // write for the client
    private BufferedReader in; // read from the client

    public Client(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        // Do client process
        outToClient(inFromClient().toUpperCase());
        closeConnection();
    }

    private String inFromClient() {

        String messageFromClient = "";

        /*
         *  Do not use try with resources because once -
         *  - it exits the block it will close your client socket too.
         */
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            messageFromClient = in.readLine();
        } catch (IOException e) {
            Logger.getLogger(getClass().getName()).severe("InFromClientErr - " + e.getMessage());
        }

        return messageFromClient.trim().equals("") ? "No Inputs given!" : messageFromClient;
    }

    private void outToClient(String message) {
        try {
            out = new DataOutputStream(clientSocket.getOutputStream());
            out.writeBytes(message);
        } catch (IOException e) {
            Logger.getLogger(getClass().getName()).severe("OutToClientErr - " + e.getMessage());
        }
    }

    private void closeConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (NullPointerException | IOException e) {
            Logger.getLogger(getClass().getName()).severe(e.getMessage());
        }
    }
}