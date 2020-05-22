synchronized (location) {
    while(true) {
        //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 9000);

        ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());

        //ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());

        outToServer.writeObject(location);

        outToServer.flush();
        clientSocket.close();
        location.wait();
    }
}