public class ClientHandler implements Runnable {
    private Socket socket;
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());

        clientSentence = inFromClient.readLine();
        clientSentenceLength = clientSentence.length();
        outToClient.writeBytes(clientSentenceLength + "" + '\n');

        socket.close();
    }
}