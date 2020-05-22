Soda2Consumer consumer = Soda2Consumer.newConsumer("https://sandbox.demo.socrata.com");

    ClientResponse response = consumer.query("nominationsCopy",
            HttpLowLevel.JSON_TYPE,
            SoqlQuery.SELECT_ALL);
    String payload = response.getEntity(String.class);
    System.out.println(payload);