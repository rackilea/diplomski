// Synchronized set because we're in a multithreaded environment
static Set<RequestHandler> connected = Collections.synchronizedSet(new LinkedHashSet<>());

public static void notifyClients(RequestHandler sender, String clientMSG) {
    System.out.println("Echoing Message to " + (numClients - 1) + " clients...");

    // Defensive copy in case the client vector is modified while we iterate over it
    List<RequestHandler> connected;
    synchronized (Server.connected) {
        connected = new ArrayList<>(Server.connected);
    }

    for (RequestHandler client : connected) {
        try {
            if (!(client.equals(sender))) {
                client.sendMSG("client " + sender + ": " + clientMSG);
                System.out.println(sender + " wrote: \"" + clientMSG + "\" to " + client);
            }
        } catch (IOException e) {
            System.err.println("Couldn't write to " + client);
            Server.connected.remove(client);
        }
    }
}