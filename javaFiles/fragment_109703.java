public class serverpart {
    public static Socket socket;
    public static void main(String[]args) throws IOException {
        int port = 8080;
        ...
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(returnedMessage);
            bw.newLine();
            ...