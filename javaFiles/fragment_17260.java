public class ChatServerBroadcast implements Runnable{
    private String message = "";

    public ChatServerBroadcast() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ready to chat ");
        while(true) {
            try {
                message = in.readLine();
            } catch (IOException e) {
                message = "";
            }
            if(!message.isEmpty()) {
                message = "[SERVER BROADCAST] " + message + "\r\n";
                ChatServerhandler.sendServerMessage(message);
                message = "";
            }
        }

    }   
}