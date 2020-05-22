public class ChatServer {

    public static void main(String args[]) {
        int port = 1337;

        try {
            ServerSocket server = new ServerSocket(port);
            String inMessage = "";

            while (true) {
                System.out.println("Waiting");
                Socket clientA = server.accept();
                System.out.println("Connected");
                DataInputStream inA = new DataInputStream(clientA.getInputStream());
                DataOutputStream outA = new DataOutputStream(clientA.getOutputStream());
                // outA.writeUTF("Welcome to the Chat Server. Type '/close' or Click 'Disconnect' to close.");

                // for testing
                // BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
                do {
                    inMessage = inA.readUTF();

                    if (inMessage != null) {
                        outA.writeUTF(inMessage);
                    }

                } while (!inMessage.equals("/close"));
                clientA.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}