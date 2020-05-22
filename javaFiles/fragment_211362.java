from("file:data/inbox?noop=true")
                .marshal()
                .string()
                .setHeader(Exchange.CONTENT_TYPE,constant("application/json"))
                .to("http://www.a-service.com")
                .choice()
                .when(simple("${body} contains 'OK'")).to("activemq:okqueue")
                .otherwise().to("activemq:queue:other");