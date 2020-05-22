import java.io.DataInputStream;
import java.io.DataOutputStream;

import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;

public class Desktop {

    public static void main(String[] args) {
        Bluetooth bluetooth = new Bluetooth();
        bluetooth.listen();
    }
}

class Bluetooth implements Runnable {
    // the uid of the service, it has to be unique
    final UUID uuid = new UUID("22022c0c68af4cbc8dbf0bbaf2aa222a", false);
    // the name of the service
    final String name = "Echo Server";
    // the service url
    final String url = "btspp://localhost:" + uuid + ";name=" + name + ";authenticate=false;encrypt=false;";

    DataOutputStream dout;
    DataInputStream din;
    LocalDevice local = null;
    StreamConnectionNotifier server = null;

    StreamConnection conn = null;
    // if client is ready to receive data
    boolean remoteReady = true;

    public Bluetooth() {
        try {
            local = LocalDevice.getLocalDevice();
            local.setDiscoverable(DiscoveryAgent.GIAC);
            server = (StreamConnectionNotifier) Connector.open(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        try {
            Thread t = new Thread(this);
            t.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error " + e.toString());
        }
    }

    public void run() {
        try {
            boolean listening = true;
            boolean firstTime = true;
            String cmd = "";
            while (true) {
                try {
                    if (listening) {
                        conn = server.acceptAndOpen();
                        // Client Connected waiting for incoming data
                        din = new DataInputStream(conn.openInputStream());
                        dout = new DataOutputStream(conn.openOutputStream());
                        listening = false;
                        firstTime = false;
                    } else {
                        cmd = din.readUTF();
                        if (cmd.equals("ACK"))
                            remoteReady = true;
                        /**
                         * here you can send the cursor position
                         */

                        String position = "{x:1,y:1}";
                        sendDataIfReady(position.getBytes());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    close();
                    if (firstTime) {
                        e.printStackTrace();
                        return;
                    }
                    listening = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendData(String data) {
        try {
            dout.writeUTF(data);
            dout.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean sendDataIfReady(String data) {
        boolean result = false;
        try {
            if (remoteReady) {
                remoteReady = false;
                dout.writeUTF(data);
                dout.flush();
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void sendData(byte[] data) {
        try {
            dout.write(data, 0, data.length);
            dout.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean sendDataIfReady(byte[] data) {
        boolean result = false;
        try {
            if (remoteReady) {
                remoteReady = false;
                dout.write(data, 0, data.length);
                dout.flush();
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}