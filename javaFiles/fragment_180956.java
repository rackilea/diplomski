try {
    Socket connection = new Socket(mHostAddress, mHostPort);
    connection.setSoTimeout(mTimeOut);
    ObjectOutputStream outgoing = new ObjectOutputStream(
            new BufferedOutputStream(connection.getOutputStream()
            )); // <-- Opening output stream first in client (opposite to server)
    outgoing.writeObject(mMessage);
    outgoing.flush();
    outgoing.close(); // <-- closing the stream as per EJP's comment
} catch (IOException ex) {
    System.out.print("IOException in TCPSender: " + ex.getMessage());
}