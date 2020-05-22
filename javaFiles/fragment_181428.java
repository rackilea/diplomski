public class DevLogServer {

  public static void main(String[] args) throws IOException {

    final File socketFile = new File("/dev/log");
    AFUNIXServerSocket server = AFUNIXServerSocket.newInstance();
    try {
      server.bind(new AFUNIXSocketAddress(socketFile));
    } catch (Exception e) {
      throw e;
    }

  }

}