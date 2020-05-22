boolean flag;
    System.out.println("Rozmiar queue " + queueNames.size());
    for (int i = 0; i < queueNames.size(); i++) {

        Channel channel = connection.createChannel();
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(queueNames.get(i).toString(), true, consumer_tag, consumer);

        flag = true;
        while (flag) {

            QueueingConsumer.Delivery delivery = consumer.nextDelivery(timeout);
            if (delivery == null) {
                flag = false;
            } else {

                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Message Received '" + message + "'");
            }
        }
    }