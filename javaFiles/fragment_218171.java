import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ShellServer {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = null;
        Socket client = null;
        String resultado;
        String comando;
        String s = null;
        socket = new ServerSocket(1234);

        System.out.println("El servidor sigue funcionando...");
        while (true) {
            client = socket.accept();
            System.out.println("El cliente se ha conectado");
            DataInputStream in = new DataInputStream(new BufferedInputStream(client.getInputStream()));
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));

            comando = in.readUTF();
            if ("0".equals(comando)) {
                System.exit(0);
            }
            resultado = Shell.CheckCommand(comando);

            // Ejcutamos el comando
            Process p = Runtime.getRuntime().exec(comando);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));

            while ((s = stdInput.readLine()) != null) {
                out.write(s.getBytes("UTF-8"));
                out.write('\n');
                // we want to see each line as fast as we can
                out.flush();
                System.out.println(s);
            }
            client.close();            
        }
    }
}