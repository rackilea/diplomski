public class TaskExecutionServer {
    public TaskExecutionServer(final int port) {
        new Thread() {
            @Override
            public void run() {
                try {
                    int counter = 0;
                    ServerSocket serverSocket = new ServerSocket(port);

                    while(true) {
                        System.out.println("Waiting for client...");
                        Socket socket = serverSocket.accept();
                        System.out.println("Accepted");
                        InputStream inputStream = socket.getInputStream();
                        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
                        ObjectInputStream objectStream = new ObjectInputStream(pushbackInputStream);
                        for(int i; (i = pushbackInputStream.read()) != -1;) {
                            pushbackInputStream.unread(i);
                            String to = (String) objectStream.readObject();
                            System.out.println(to);
                            System.out.println(++counter);
                        }
                        objectStream.close();
                        pushbackInputStream.close();
                        inputStream.close();

                        System.out.println("Closing socket");
                        socket.close();
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