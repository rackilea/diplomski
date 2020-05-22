public class TaskExecutionServer {
    public TaskExecutionServer(final int port) {
        new Thread() {
            @Override
            public void run() {
                try (ServerSocket serverSocket = new ServerSocket(port)) {
                    int counter = 0;

                    while(true) {
                        System.out.println("Waiting for client...");
                        try (Socket socket = serverSocket.accept();
                             InputStream inputStream = socket.getInputStream();
                             PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
                             ObjectInputStream objectStream = new ObjectInputStream(pushbackInputStream)) {
                            System.out.println("Accepted");
                            for(int i; (i = pushbackInputStream.read()) != -1;) {
                                pushbackInputStream.unread(i);
                                String to = (String) objectStream.readObject();
                                System.out.println(to);
                                System.out.println(++counter);
                            }
                            System.out.println("Closing socket");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public static void main(String args[]) {
        new TaskExecutionServer(2003);
    }
}