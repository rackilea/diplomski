while(socket != null) {
  try {
    sendData = sendQueue.poll(10, TimeUnit.SECONDS);
    if (sendData != null) {
      sendPacket(sendData);
    } else {
      sendPacket("/xremote".getBytes());
      sendPacket("/info".getBytes());
    }
  } catch (IOException e) {
    e.printStackTrace();
    if (!e.getMessage().contains("Socket closed")) {
      e.printStackTrace();
    }
  }
}