public static void main(String[] args) throws Exception {

    String clientSentence;
    String capitalizedSentence;
    ServerSocket Socket = new ServerSocket(6789);

    while (true)
    {
        Socket connection = Socket.accept();
        while(true)
        {
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connection.getOutputStream());
            clientSentence = inFromClient.readLine();
            System.out.println(clientSentence);
            capitalizedSentence = clientSentence + '\n';
            outToClient.writeBytes(capitalizedSentence);
            System.out.println("Sent msg");
        } 
    }
}