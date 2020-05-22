while (running){
    try{
        client = serverSocket.accept();
        createComms(client);
    } catch (IOException ex){
        // Log errors
        LOG.warn(ex,ex);
    }
}