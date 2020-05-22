from("direct://PublishToRabbitMQ")

        .setHeader("rabbitmq.ROUTING_KEY", constant("SOMEROUTINGKEY"))
        .setHeader("rabbitmq.EXCHANGE_NAME",constant("EXCHANGE_NAME"))          
        .setHeader("timestamp", constant(new Date(System.currentTimeMillis())))
        .doTry()
        .to("rabbitmq://localhost/EXCHANGE_NAME/?exchangeType=Topic&autoDelete=false&durable=false")
        .convertBodyTo(String.class)    

    .end();