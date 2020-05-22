class User implements Runnable {
    private Socket socket;
    private boolean connected;

    private DataOutputStream out; //so we can access from the #send(String) method

    public User(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        connected = true;

        try(DataInputStream in = new DataInputStream(socket.getInputStream())) {
            out = new DataOutputStream(socket.getOutputStream());

             while(connected) {
                 String data = in.readUTF();
                 System.out.println("From client: "+data);
                 //send to all clients
             }
         } catch(IOException e) {
             //if there's a problem initializing streams;
             //if socket closes while attempting to read from it;
             e.printStackTrace();
         }
    }

    public void send(String message) throws IOException {
        if(connected) {
            out.writeUTF(message);
            out.flush();
        }
    }
}