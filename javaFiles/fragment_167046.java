while (true) {
    try {
        Thread.sleep(20);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    try {
        clientSocket = serverSocket.accept(); 
        ...
    }
    ...
}