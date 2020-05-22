from(URI_WEBSERVICE)
            .convertBodyTo(Entrada.class)
            .process(new Processor() {
                @Override
                public void process(Exchange exchange) throws Exception {
                    // logic of ProcessorTratarWS goes here
                    ConsumerTemplate consumer=exchange.getContext().createConsumerTemplate();
                    String filename=exchange.getProperty("archivoRespuesta",String.class);                  
                    Object file=consumer.receiveBody("ftp://10.100.8.2/entradaCamel?username=USER&password=PASSWORD&delete=true&fileName="+filename,timeOut);
                    // logic of EstrategiaConfirmacion goes here
            }

        })
        .to(WS_RESPONDER);