public class Server extends Thread {

    public static final int PORT = 3332;
    public static final int BUFFER_SIZE = 626;

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket s = serverSocket.accept();
                saveFile(s);
            }
        } catch (Exception e) {
        }
    }

    private void saveFile(Socket socket) throws Exception {
        InputStream ois = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("C:\\2049.jpg");;

        byte[] mybytearray = new byte[1024];
        System.out.println("Reading file from server...");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int bytesRead;
        while ((bytesRead = ois.read(mybytearray)) != -1) {
            bos.write(mybytearray);
        }

        bos.close();
        System.out.println("Writing file complete...");

    }

    public static void main(String[] args) {
        new Server().start();
    }
}