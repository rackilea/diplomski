channel.addReturnListener(new ReturnListener() {
  @Override
  public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
    System.out.println("App.handleReturn");
    System.out.println("replyCode = [" + replyCode + "], replyText = [" + replyText + "], exchange = [" + exchange + "], routingKey = [" + routingKey + "], properties = [" + properties + "], body = [" + body + "]");
  }
});