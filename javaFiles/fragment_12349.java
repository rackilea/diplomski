/* Command Exception. */
public class ClientCommandException extends Exception {
    public ClientCommandException(String msg) {
        super(msg);
    }
}

/* The ClientCommand interface */
public interface ClientCommand {
    void execute(Client client, String[] params) throws ClientCommandException;
}

import java.util.HashMap;
import java.util.Arrays;

/* Container for commands */
public class Commands implements ClientCommand {
    private HashMap<String, ClientCommand> cmds;

    public Commands() {
        cmds = new HashMap<String, ClientCommand>();
    }

    public void addCommand(ClientCommand cmd, String name) {
        cmds.put(name, cmd);
    }

    public void execute(Client client, String[] params) throws ClientCommandException {
        ClientCommand cmd = cmds.get(params[0]);
        if(cmd != null) {
            cmd.execute(client, Arrays.copyOfRange(params, 1, params.length));
        } else {
            throw new ClientCommandException("Unknown Command: " + params[0]);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Client implements Runnable {

    private boolean isConnected;
    private Commands cmds;
    private BufferedReader in;
    private PrintWriter out;

    private class EchoCommand implements ClientCommand {
        public void execute(Client client, String[] params) throws ClientCommandException {
            StringBuilder b = new StringBuilder("Echo back:");
            int len = params.length;
            for(int i = 0; i < len; i++) {
                b.append(' ');
                b.append(params[i]);
            }
            client.send(b.toString());
        }
    }

    private class DisconnectCommand implements ClientCommand {
        public void execute(Client client, String[] params) throws ClientCommandException {
            client.close();
        }
    }

    public Client() {
        cmds = new Commands();
        cmds.addCommand(new EchoCommand(), "echo");
        cmds.addCommand(new DisconnectCommand(), "disconnect");
        /* sub-commands */
        Commands server = new Commands();
        server.addCommand(new EchoCommand(), "print");
        cmds.addCommand(server, "server");
        isConnected = true;
    }

    public void addCommand(ClientCommand cmd, String name) {
        cmds.addCommand(cmd, name);
    }

    public void close() {
        isConnected = false;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out, true);

            while (isConnected) {
                String recv = in.readLine().trim();

                if (recv != null) {
                    String[] data = recv.split("%");
                    try {
                        cmds.execute(this, data);
                    } catch(ClientCommandException e) {
                        /* Return some error back to the client. */
                        out.println(e.toString());
                    }
                }
            }
        } catch (IOException e) {}
    }

    public synchronized void send(String data) {
        out.println(data);
    }

    public static void main(String[] args){
        Client client = new Client();
        System.out.println("Start Client.");
        client.run();
    }
}