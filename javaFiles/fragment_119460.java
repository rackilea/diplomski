String myPersistentQueue = "myPersistentQueue";
            boolean isDurable = true;
            boolean isExclusive = false;
            boolean isAutoDelete = false;
            channel.queueDeclare(myPersistentQueue, isDurable, isExclusive, isAutoDelete, null);
            channel.queueBind(myPersistentQueue, "myTopic", "kern.#");
            final QueueingConsumer consumer = new QueueingConsumer(channel);
            boolean autoAck = true;
            String tag1 = channel.basicConsume(myPersistentQueue, autoAck, consumer);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        Delivery delivery;
                        try {
                            delivery = consumer.nextDelivery();
                            String message = new String(delivery.getBody());
                            System.out.println("Received: " + message);
                        } catch (Exception ex) {
                            Logger.getLogger(TestMng.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
            System.out.println("Consumers Ready");