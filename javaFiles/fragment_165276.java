public String recv() throws Exception {
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
    MyConsumer consumer=new MyConsumer(channelRecv);
    channelRecv.basicConsume(queRecv,true,consumer);

    consumer.getStoredMessage(); // use stored value here
}

public class MyConsumer extends DefaultConsumer {
    private String storedMessage;

    public MyConsumer(Object channelRecv) {
        super(channelRecv);
    }

    public String getStoredMessage() {
        return storedMessage;
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
            throws IOException {
        String message = new String(body, "UTF-8");
        System.out.println(" [x] Received '" + message + "'");
        storedMessage = message; // store message here
    }
}