try {
    ObjectInputStream input = new ObjectInputStream(
            new BufferedInputStream(aClient.getInputStream()) // Input first in server
    );
    NetworkMessage message = (NetworkMessage) input.readObject();
    input.close(); // <-- closing stream
    aClient.close(); // <-- making sure to close the Socket connection to client

    act(message, sendersIP); <-- acting on the message from client

} catch (IOException ex) {
    System.out.println("An IO exception occurred "
            + "in NetworkMessageHandler: " + ex.getMessage());
} catch (ClassNotFoundException ex) {
    System.out.println("Could not recreate the sent class: "
            + ex.getMessage());
}