@Bean
public IntegrationFlow mailListener() {
    return IntegrationFlows.from(Mail.imapInboundAdapter("imaps://[username]:[password]@imap.gmail.com/INBOX")
             .shouldDeleteMessages(true).get(), 
             e -> e.poller(Pollers.fixedRate(5000).maxMessagesPerPoll(1)))
        .<Message>handle((payload, header) -> logMail(payload))
        .get();
}