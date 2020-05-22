public void sendMessageToServer(String message) {

    if (message != null) {
        try {
            //Assume I already have an instance of client Socket:
            //Socket outgoingConn = new Socket(host, port)
            //1. I get the OutputStream of my outgoing connection
            OutputStream outStream = outgoingConn.getOutputStream();
            //2. Create an object output stream
            ObjectOutputStream objectWriter = new ObjectOutputStream(outStream);
            //3. Write the object
            objectWriter.writeObject(message);
            //Close the io if required (would recommend try-with-resources if using jdk7)
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}