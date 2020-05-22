import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class ShellClient {

    public static void main(String[] args) throws IOException {
        String comando;

        while (true) {
            System.out.println("Introduce ipconfig(windows)/ ifconfig(Linux): ");
            @SuppressWarnings("resource")
            Scanner keyboard = new Scanner(System.in);

            comando = keyboard.next();

            System.out.println("Conectando...");
            // We need a new connection for every request
            Socket server = new Socket("localhost", 1234);
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(server.getOutputStream()));
            DataInputStream in = new DataInputStream(new BufferedInputStream(server.getInputStream()));

            out.writeUTF(comando);
            out.flush();
            // We close the output stream so the server knows we have finished the request
            server.shutdownOutput();
            if ("0".equals(comando)) {
                System.out.println("Finalizado. Gracias!");
                System.exit(0);
            }
            BufferedReader input = new BufferedReader(new InputStreamReader(server.getInputStream(), "UTF-8"));
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            // See above - we need a new connection for every request
            server.close();
        }
    }
}