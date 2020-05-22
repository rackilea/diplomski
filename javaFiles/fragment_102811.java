channel.addReturnListener(new ReturnListener() {
      @Override
      public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
        System.out.println("App.handleReturn");
        System.out.println("replyCode = [" + replyCode + "], replyText = [" + replyText + "], exchange = [" + exchange + "], routingKey = [" + routingKey + "], properties = [" + properties + "], body = [" + body + "]");
      }
    });

    channel.addConfirmListener(new ConfirmListener() {
      @Override
      public void handleAck(long deliveryTag, boolean multiple) throws IOException {
        System.out.println("App.handleAck");
        System.out.println("deliveryTag = [" + deliveryTag + "], multiple = [" + multiple + "]");
      }

      @Override
      public void handleNack(long deliveryTag, boolean multiple) throws IOException {
        System.out.println("App.handleNack");
        System.out.println("deliveryTag = [" + deliveryTag + "], multiple = [" + multiple + "]");
      }
});

long nextPublishSeqNo = channel.getNextPublishSeqNo();
System.out.println("nextPublishSeqNo = " + nextPublishSeqNo);

channel.basicPublish("headers_logs",
    "",
     true,
     props,
    "data".getBytes());