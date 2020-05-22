from("direct:sendFileExchange")
            .errorHandler(deadLetterChannel("direct:savefile").useOriginalMessage()
                .asyncDelayedRedelivery()
                .maximumRedeliveries(3)
                .redeliveryDelay(1000)
                .retryAttemptedLogLevel(LoggingLevel.WARN))

            .startupOrder(3)
            .process(new ProcessorSetFileRequest())
            .setHeader(Exchange.HTTP_METHOD, constant("POST"))
            .setHeader(Exchange.HTTP_QUERY,constant("USERNAME=__&PASSWORD=_"))
            .to("https4://someAddress/uploadAndImportFileFromCSVFile?throwExceptionOnFailure=false")
            .to("stream:out");

 from("direct:savefile").process(exchange -> {
          MultipartFormEntity body = (MultipartFormEntity) exchange.getIn().getBody();
          exchange.getOut().setBody(body.getContent());
        }).to("file:/home/r2/Desktop/ofBizFile/errorFinalServer");