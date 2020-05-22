public class Client {

    public static void main(String[] args) throws Exception {
        String fileName = "C:\\2048.jpg";

        try {
            File file = new File(fileName);
            Socket socket = new Socket("localhost", 3332);
            byte[] mybytearray = new byte[(int) file.length()];
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            bis.read(mybytearray, 0, mybytearray.length);
            OutputStream os = socket.getOutputStream();
            os.write(mybytearray, 0, mybytearray.length);
            os.flush();
            os.close();
        } catch (Exception e) {
        }

    }
}