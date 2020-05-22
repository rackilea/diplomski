class EchoThread extends Thread {
//*****What I add begin.
private static List<Socket> socketList = new ArrayList<>();
//*****What I add end.

private Socket socket;

//constructor
public EchoThread(Socket clientSocket) {
    this.socket = clientSocket;
    socketList.add(socket);
}

@Override
public void run() {
    DataInputStream inp = null;

    try {
        inp = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        //print whatever client is saying as long as it is not "Over"
        String line = "";
        while (!line.equals("Over")) {
            try {
                line = inp.readUTF();
                System.out.println(line);

                //*****What I add begin.
                sendMessageToClients(line);
                //*****What I add end.
            } catch (IOException e) { System.out.println(e); break;}
        }

        //closes connection when client terminates the connection
        System.out.print("Closing Connection");
        socket.close();
    } catch (IOException e) { System.out.println(e); }
}

//*****What I add begin.
private void sendMessageToClients(String line) throws IOException {
    for (Socket other : socketList) {
        if (other == socket) {
            continue;//ignore the sender client.
        }
        DataOutputStream output = new DataOutputStream(other.getOutputStream());
        output.writeUTF(line);
    }
}
//*****What I add end.