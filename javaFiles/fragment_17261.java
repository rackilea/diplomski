public static void sendServerMessage(String message) {
    if (channels.isEmpty()) {
      return;
    }
    channels.writeAndFlush(message);
}