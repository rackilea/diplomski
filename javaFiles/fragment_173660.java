try{
    clientIP = socket.getLocalAddress().getHostName();

    //This will add a new Button to the ArrayList with the Text of the Button being the Clients Host Name
    buttons.add(new JButton(clientIP));

    System.out.println("Client conneted from :" + clientIP);
    displayButton(buttons.get(clientNumber);
    clientNumber++;
}