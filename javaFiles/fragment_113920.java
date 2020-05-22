public class ClientA {
private Socket socket = null;
private DataInputStream input = null;
private DataOutputStream output = null;

public ClientA(String address, int port) {
    //establish connection
    try {
        socket = new Socket(address, port);
        System.out.println("Connected");

        //takes input from terminal
        input = new DataInputStream(System.in);

        //sends output to the socket
        output = new DataOutputStream(socket.getOutputStream());

        //*****What I add begin.
        //Here create a thread to receive message from server.
        DataInputStream inp = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        new Thread(() -> {
            while (true) {
                String str;
                try {
                    str = inp.readUTF();
                    System.out.println(str);
                } catch (IOException e) {
                    e.printStackTrace();//error.
                    break;
                }
            }
        }, "Client Reveiver.").start();
        //*****What I add end.

    } catch (IOException e) { System.out.println(e); }

    //string to read message from input
    String line = "";

    //keep reading until "Over" is input
    while (!line.equals("Over")) {
        try {
            line = input.readLine();
            output.writeUTF(line);
        } catch (IOException e) { System.out.println(e); }
    }
    //close the connection
    try {
        input.close();
        output.close();
        socket.close();
    } catch (IOException e) { System.out.println(e); }
}