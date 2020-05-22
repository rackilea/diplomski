public class Client {
    public static void main(String[] args) {
        try (Socket client = new Socket("localhost", 8);
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter outToServer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            Scanner input = new Scanner(System.in)) {

            System.out.println("Connected to server");
            String strClient,strServer;

            while(true){
                System.out.print("Client: ");
                strClient = input.nextLine();
                outToServer.write(strClient);
                outToServer.newLine();
                outToServer.flush();
                strServer = inFromServer.readLine();
                System.out.println("Server: " + strServer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}