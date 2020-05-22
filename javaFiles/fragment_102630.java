public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8);
            Socket client = server.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter outToClient = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {

            String in = inFromClient.readLine(), out;
            while(in != null){
                out = in + " from server";
                outToClient.write(out);
                outToClient.newLine();
                outToClient.flush();
                in = inFromClient.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}