Thread t = new Thread(new Runnable() {
    @Override
    public void run() {
       Server server = new Server(8080);
       if(server.serverCreated){
          server.clientsListener();
       }
    }
});

t.setDaemon(true);
t.start();