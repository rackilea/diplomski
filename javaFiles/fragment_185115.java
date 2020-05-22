private void handleInput(String term1, String term2, int code)
    throws IOException {
  String message;

  switch (code) {
    case 1:
      int comparison = term1.compareTo(term2);

      if (comparison > 0) {
        message = term1 + " comes after " + term2 + " lexicographically";
      } else if (comparison < 0) {
        message = term1 + " comes before " + term2 + " lexicographically";
      } else {
        message = "Term1 and term2 are the same";
      }

      break;
    // Other cases omitted, since you said you could figure them out.
    default:
      throw new IOException("Unknown code: " + code);
  }

  byte[] sendBuffer = message.getBytes();
  DatagramPacket packet = new DatagramPacket(sendBuffer, sendBuffer.length,
                                             host, port);
  socket.send(packet);
}