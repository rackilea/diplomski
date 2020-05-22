import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {

    public static void main(String[] args) {

        Socket clientSocket;

        try {
            clientSocket = new Socket("localhost", 3000);

            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            outToServer.writeBytes(new Scanner(System.in).nextLine() + '\n'); // Get user input and send.
            System.out.println(inFromServer.readLine()); // Print the server response.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}