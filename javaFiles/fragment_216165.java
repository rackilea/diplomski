public static void main(String[] args) throws Exception,URISyntaxException {
      ConnectionFactory factory = new ConnectionFactory();
      factory.setUri("amqp://kobqwlov:GANqOND_L4bxqEwqNSQA5BNqGt-X2NqM@lemur.cloudamqp.com/kobqwlov");
      Connection conn = factory.newConnection();
      Connection connection = factory.newConnection();
      Channel channel = connection.createChannel();
      channel.queueDeclare("QUEUE_NAME", false, false, false, null);
      String message = "Hello From The Outside!!!";
      channel.basicPublish("", "QUEUE_NAME", null, message.getBytes());
      System.out.println(" [x] Sent '" + message + "'");
      channel.close();
      conn.close();
    }