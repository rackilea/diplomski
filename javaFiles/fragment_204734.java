private static DataInputStream socketIn;
  private static DataOutputStream socketOut;
  private static final String SERVICES_FILE = "/etc/services";

  public static void main(String[] args) {
    int port = getServicePortByName("Service1", "tcp");
    try {
      logger.info("Creating socket port with ip: " + InetAddress.getLocalHost() + " and port: " + port);
      Socket socket = new Socket(InetAddress.getLocalHost(), port);
      socketIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
      socketOut = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

      byte[] message = createMessageXML("LOGIN");
      socketOut.writeInt(message.length());
      socketOut.write(message, 0, message.length());

      int len = socketIn.readInt();
      if (len > 0)
      {
          message = new byte[len];
          socketIn.readFully(message);
          parseReceivedMessage(message);
      }

    } catch (UnknownHostException ex) {
      Logger.getLogger(TestClient.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(TestClient.class.getName()).log(Level.SEVERE, null, ex);
    }
  }