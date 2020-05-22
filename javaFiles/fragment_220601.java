@Test
public void configureExcange() throws Exception {

    PollingConsumer pollingConsumer = null;
    try {
        CamelContext context = new DefaultCamelContext();
        Endpoint endpoint =
                context.getEndpoint("imaps://imap.gmail.com?username="
                + mailId + "&password=" + password
                + "&delete=false&peek=false&unseen=true&consumer.delay=60000&closeFolder=false&disconnect=false");
            // options unseen=true, will only poll unread mails

            //Polling an END point
            pollingConsumer = endpoint.createPollingConsumer();
            pollingConsumer.start();
            pollingConsumer.getEndpoint().createExchange();

            Exchange exchange = pollingConsumer.receive(60000);

            while (exchange != null) {
                process(exchange);
                //each time "pollingConsumer" will poll 1 mail at a time
                exchange = pollingConsumer.receive(60000);
            }
    } catch (Exception e) {
        e.printStackTrace();
    }
}