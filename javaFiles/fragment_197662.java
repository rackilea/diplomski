package demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class MultithreadedServer {

    public static final int PORT = 10000;

    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(PORT)) {
            while(true){
                Socket connection = server.accept();
                Thread client = new ClientThread(connection);
                client.start();
            }
        } catch (IOException ex) {
            System.out.println("Error start server");
        }
    }

}

class ClientThread extends Thread {
    private Socket connection;

    public ClientThread(Socket connection) {
        this.connection = connection;
    }

    @Override
    public void run(){
        //Do communication with client
    }

}