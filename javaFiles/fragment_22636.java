// Create and main list of active clients based on their host name / ip address
ConcurrentHashMap<String, Socket> activeClients = new ConcurrentHashMap<String, Socket>();

// message received
activeClients.put(clientsocket.getInetAddress().getHostAddress(), clientsocket);

// broadcast message to all available clients
for(String clientHost : activeClients.keySet()) {
      // get each socket here and send a message to them.
}