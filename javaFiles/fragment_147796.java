public void start() {
    thread = new Thread(this);
    thread.start();
}

public void stop() { 
    // You should implement this too
}

public static void main(String args[]) { 
    // Instantiate a CharServer with the listening port 9191
    ChatServer chatServer = new ChatServer(9191);
    // CharServer.start() should not be confused with Thread.start();
    // This calls our custom method up above, which includes a call to
    // Thread(ChatServer).start();
    chatServer.start();

}