Properties properties = new Properties();
properties.put("metadata.broker.list", brokerList);
properties.put("serializer.class", "com.my.TestEncoder");
Producer<String, Test> producer = new Producer<String, Test>(new ProducerConfig(properties));
Test test = new Test();
KeyedMessage<String, Test> data = new KeyedMessage<String, Test>("myTopic", test);
producer.send(data);