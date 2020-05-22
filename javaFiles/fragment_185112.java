public class DatagramSR {
  private static final int MESSAGE_LEN = 60;

  private DatagramSocket socket;

  private InetAddress host;

  private int port;

  public DatagramSR(InetAddress host, int port) throws SocketException {
    this.socket = new DatagramSocket(port, host);
    this.host = host;
    this.port = port;
  }

  [...]
}