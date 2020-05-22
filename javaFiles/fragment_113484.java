from("file:/Users/smunirat/apps/destination/jms?noop=true")
            .setHeader("from", xpath("file/from/text()").stringResult())
            .setHeader("to", xpath("file/to/text()").stringResult())
            .process(new Processor() {
                @Override
                public void process(Exchange exchange) throws Exception {
                    from = exchange.getIn().getHeader("from").toString();
                    to = exchange.getIn().getHeader("to").toString();

                    exchange.getOut().setHeader("from", from);
                    exchange.getOut().setHeader("to", to);

                }
            })

            .to("log:Sundar?showAll=true&multiline=true")
            .process(new Processor() {
                @Override
                public void process(Exchange exchange) throws Exception {
                    ConsumerTemplate createConsumerTemplate = exchange.getContext().createConsumerTemplate();
                    ProducerTemplate createProducerTemplate = exchange.getContext().createProducerTemplate();
                    Exchange receive = createConsumerTemplate.receive("file://"+exchange.getIn().getHeader("from"));
                    createProducerTemplate.sendBody("file://"+exchange.getIn().getHeader("to"),receive.getIn().getMandatoryBody());

                }
            })
            .log("Message");