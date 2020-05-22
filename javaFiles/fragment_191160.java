public void process(final Exchange exchange) {
try {
    MimeMessage mimeMessage;

    final Object body = exchange.getIn().getBody();
    if (body instanceof MimeMessage) {
        // Body is directly a MimeMessage
        mimeMessage = (MimeMessage) body;
    } else {
        // Create a message with exchange data
        mimeMessage = new MimeMessage(sender.getSession());
        getEndpoint().getBinding().populateMailMessage(getEndpoint(), mimeMessage, exchange);
    }
    if (LOG.isDebugEnabled()) {
        LOG.debug("Sending MimeMessage: {}", MailUtils.dumpMessage(mimeMessage));
    }
    sender.send(mimeMessage);
    // set the message ID for further processing
    exchange.getIn().setHeader(MailConstants.MAIL_MESSAGE_ID, mimeMessage.getMessageID());
} catch (MessagingException e) {
    exchange.setException(e);
} catch (IOException e) {
    exchange.setException(e);
}
}