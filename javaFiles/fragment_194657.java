AtomicInteger playerID = new AtomicInteger(0);
while (listening) {
  ss.textArea.append("Waiting to connect with player: " + playerID.get()  + "\n");
  new ClientThread(serverSocket.accept(), player, playerID, ss.textArea).start();
  ss.textArea.append("Waiting to connect with player: " + playerID.get() + "\n");
}

class ClientThread {
  public ClientThread(Socket acceptedSocket, Vector<Player> players, AtomicInteger playerID, JTextArea textArea) {
    // etc.
    playerID.incrementAndGet();
    // etc.
  }
}