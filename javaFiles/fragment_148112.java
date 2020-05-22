@Component
public class SmsQueueConsumer {

     //I removed the autowiring of the config
     //@Autowired
     //Configuration config;

    //and placed the config as an arg to the constructor
    public SmsQueueConsumer(Configuration config) throws Exception {

        //THIS IS WHERE THE NULL POINTER OCCURS (stack trace refers to line 54)
        String rabbitMqHost = config.getString("rabbitMq.hostName");

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(rabbitMqHost);
        com.rabbitmq.client.Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(queueName, false, false, false, null);

        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {
             //... handle deliv logic
        };
    }

}