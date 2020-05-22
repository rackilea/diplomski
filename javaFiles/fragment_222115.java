public static void main(String[] args) throws Exception {
    List<String> list = Arrays.asList("one", "two", "three");
    Thread serverThread = new Thread(new Runnable() {
        public void run() {
            try {
                InputStream in = new ServerSocket(999).accept().getInputStream();
                Object object = new ObjectInputStream(in).readObject();
                System.out.println(object.getClass() + ": " + object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
    serverThread.start();
    Socket socket = new Socket("localhost", 999);
    new ObjectOutputStream(socket.getOutputStream()).writeObject(list);
    serverThread.join();
}