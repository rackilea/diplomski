class SessionHandler extends Thread {

    private Socket socket;

    public SessionHandler (Socket socket) {
        this.socket = socket;
    }

    public void run () {
        //handle the session using the socket (example)
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        //read input from inFromClient, write to outToClient
    }

}