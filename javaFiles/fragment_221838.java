long offset = 0;

    while (true) {
        FetchRequest fetchrequest = new FetchRequest(topicName, 0, offset, 10485760);

        ByteBufferMessageSet messages = consumer.fetch(fetchrequest);
        for (MessageAndOffset msg : messages) {
            System.out.println("consumed: " + Utils.toString(msg.message().payload(), "UTF-8"));
            offset = msg.offset();
        }

    }