public static void main(String[] args){
        Client client = new Client();
        System.out.println("Client is running");
        client.createGUI();     //some swing GUI things
        client.createConnectionWithServer();
        client.sendTextToServer();
    }