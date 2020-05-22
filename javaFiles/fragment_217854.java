public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1234);

        while (true) {
            // accept the connection 
            Socket s = ss.accept();

            try {
                Scanner in = new Scanner(s.getInputStream());
                PrintWriter out = new PrintWriter(s.getOutputStream(), true);

                // read a line from the client and echo it back
                String line;
                while ((line = in.nextLine()) != null) 
                    out.println(line);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                s.close();
            }
        }
    }
}