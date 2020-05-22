while(true){
    servSock = incoming.accept(); //accept incoming connections from clients
    serverListener c1 = new serverListener(servSock); //create a new chat listener object, passes in servSock socket
    c1.start();
    threadList.addLast(c1);
}//while(running)