public class User extends Thread { //create a Thread for each connection to handle data seperately
    DataInputStream in;
    DataInputStream out;

    Socket socket;
    public User(Socket socket) { //creates a stream for the socket that the user connected with
        this.socket = socket;

        initStream(); 
    }

    public void initStream() { //inits streams after socket is initiated (through ss.accept())
        try {
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        }catch(IOException e) { e.printStackTrace(); }
    }

    public void closeStream() throws IOException { //throws exception since i have a chance to catch it in my run() method
            out.close(); in.close();
            socket.close();
    }

    public void sendMessage(String string) {
        try {
            out.writeUTF(string);
        }catch(IOException e) { e.printStackTrace(); }
    }

    public void run() { //when thread starts, accept/handle data
        String input;

        try {
            while((input = in.readUTF()) != null) {
                //handle input
            }
            closeStream();
        }catch(IOException e) { e.printStackTrace(); }
    }
}