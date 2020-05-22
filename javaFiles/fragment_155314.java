public class Server implements Runnable {


    public void run() {

        int portNumber = 4444;
        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {

            while(true) {
                try (
                        Socket clientSocket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    String input = in.readLine();
                    System.out.println(input);
                }
            }

        } catch (IOException e) {
            System.err.println("Could not listen on port 4444");
            System.exit(-1);
        }

    }

}