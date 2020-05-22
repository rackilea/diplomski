from("rabbitmq://localhost/test-in?autoAck=false&autoDelete=false&durable=true&exchangeType=fanout&queue=test-in&username=guest&password=xxx")
        .log(LoggingLevel.ERROR, "Output of message from Queue: ${in.body}")
        .process(new Processor() {

            @Override
            public void process(Exchange exchange) throws Exception {
                exchange.getOut().setBody(exchange.getIn().getBody());                  
            }
        })
        .to("rabbitmq://localhost/test-out?autoAck=false&autoDelete=false&durable=true&exchangeType=fanout&queue=test-out&username=guest&password=xxx");