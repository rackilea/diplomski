public static void main(String[] args) {
  DatagramSR sr = null;

  try {
    InetAddress receiverHost = InetAddress.getByName(args[0]);
    int receiverPort = Integer.parseInt(args[1]);
    DatagramSocket mySocket = new DatagramSocket(receiverPort, receiverHost);

    sr = new DatagramSR(mySocket, receiverHost, receiverPort);
  } catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Not enough parameters given.");
  } catch (UnknownHostException e) {
    System.out.println("Give a reasonable hostname as first parameter.");
  } catch (NumberFormatException e) {
    System.out.println("Give a reasonable port number as second parameter.");
  } catch (SocketException e) {
    System.out.println("Socket creation failed.");
  }

  // If it's still null, there were errors above and no point to proceed.
  if (sr != null) {
    sr.run();
  }
}