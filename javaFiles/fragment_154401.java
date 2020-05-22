final Socket clientSocket = welcomeSocket.accept();
Thread t = new Thread(){  
  @Override public void run(){
    // BufferedReader/Writer close the underlying stream when they
    // are closed, so the socket will be closed when this
    // try-with-resources block finishes.
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));
         BufferedWriter writer = ...) {
      // Do whatever.
    } catch (IOException e) {
      // Handle the exception.
    }
  }
};
t.start();