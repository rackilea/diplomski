{
    if (clientCommand.equalsIgnoreCase("Kill")) {
       Socket socket=clients.get(idToShutDown);// get required id somehow (from request??)
       socket.close();
    }
}