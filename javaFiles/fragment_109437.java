import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClientThread extends Thread{

    private ClientThread[] clientsConnected;
    private Socket socket = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private String clientName = null;

    //Constructor
     public ClientThread(Socket socket, ClientThread[] clientsConnected){
        this.socket = socket;
        this.clientsConnected = clientsConnected;
    }

    public void run(){
        try {
            // Streams :)
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            String message = null;

            clientName = in.readUTF();

            while (true){
                message = in.readUTF();

                for (int c = 0; c < clientsConnected.length; c++){
                    if (clientsConnected[c]!= null && clientsConnected[c].clientName != this.clientName){ //dont send message to your self ;)
                        clientsConnected[c].sendMessage(message, clientName); // loops through all the list and calls the objects sendMessage method.
                    }
                }

            }

        } catch (IOException e) {
            System.out.println("Client disconnected!");
            this.clientsConnected = null;
        }
    }
    // Every instance of this class ( the client ) will have this method.
    private void sendMessage(String mess, String name){
        try {
            out.writeUTF(name + " says: " + mess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}