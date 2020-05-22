public void transmitMessage(String message) {
    if (clientSocket_ == null || !clientSocket_.isBound()) {
        System.out.println("Not connected, can't transmit. Make sure you are connected to the host\nClientsocket " +
                "is null or not bound");
        return;
    }

    try {
        if (outToServer == null)
            outToServer = new DataOutputStream(clientSocket_.getOutputStream());


        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket_.getOutputStream())), true);
        pw.println(message);
        pw.flush();

    } catch (IOException e) {
        System.out.println("Error while writing to socket - message not delivered");

    }

}