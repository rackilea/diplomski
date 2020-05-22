.handle(Amqp.outboundAdapter(amqpTemplate())
                    .exchangeName("barrierExchange")
                    .routingKey("barrierKey")
                    .confirmAckChannel(confirmAckChannel())
                    .confirmCorrelationExpression("payload")
            )
            .get();