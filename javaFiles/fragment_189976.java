ConnectionFactory factory = new ConnectionFactory();
factory.setHost("localhost");
factory.setPort(5672);
final ExceptionHandler eh = new DefaultExceptionHandler() {
    @Override
    public void handleConsumerException(Channel channel, Throwable exception, Consumer consumer, String consumerTag, String methodName) {
        System.out.println(" - Error raised by: " + channel.getChannelNumber());
    }
};
factory.setExceptionHandler(eh);

final Connection connection = factory.newConnection();
final Channel channel = connection.createChannel();


channel.queueDeclare("my_queue",true,false,false,null);
channel.basicConsume("my_queue", true, new DefaultConsumer(channel) {
    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

        System.out.println("Received...");
        System.out.println("error:"+ Integer.parseInt("RAISE_AN_ERROR"));