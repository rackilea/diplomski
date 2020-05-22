@MessageMapping("/meeting/{roomId}")
private void sendMessageTpPrivateRoom(String message, @DestinationVariable String roomId) throws IOException {
    System.out.println("message sent to: " + roomId);
    this.template.convertAndSend("/meeting/" + roomId, message);
    addToHistory(roomId, message);
}