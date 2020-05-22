NetworkMessage message = new NetworkMessage();
for(;;) {
  message.setProperty(whatever);
  oos.reset();
  oos.writeObject(message);
}