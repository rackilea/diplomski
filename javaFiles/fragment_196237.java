public void configure() throws Exception {
        from("direct:message")
            .setHeader("CamelTwilioTo", constant(new PhoneNumber(to)))
            .setHeader("CamelTwilioFrom", constant(new PhoneNumber(from)))
            .setHeader("CamelTwilioBody", constant(message))
            .to("twilio://message/creator");
    }