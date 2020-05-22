ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();
    channel.basicQos(1);
    channel.queueDeclare(QUEUE_NAME, true, false, false, null);
    System.out.println("[*] waiting for messages. To exit press CTRL+C");

    QueueingConsumer consumer = new QueueingConsumer(channel);
    channel.basicConsume(QUEUE_NAME, consumer);
    while(true) {
        QueueingConsumer.Delivery delivery = consumer.nextDelivery();
        int n = channel.queueDeclarePassive(QUEUE_NAME).getMessageCount();
        System.out.println(n);
        if(delivery != null) {
            byte[] bs = delivery.getBody();
            System.out.println(new String(bs));
            //String message= new String(delivery.getBody());
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            //System.out.println("[x] Received '"+message);
        }
    }