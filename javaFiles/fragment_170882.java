from("file:G:/highlight").to("activemq:topic:newVersion");
        from("activemq:topic:newVersion").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                long time = System.currentTimeMillis();
                Date date = new Date(time);
                System.out.println(date);

            }
        });