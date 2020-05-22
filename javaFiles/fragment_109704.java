public class clientpart {
    public static void main(String[]args) throws IOException {
        Scanner input = new Scanner(System.in);
        int port = 8080;
        ...
        bw.write(sendMessage);
        bw.newLine();
        bw.flush();
        ...