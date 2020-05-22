...
    try {
        result = performWsRequest(request, soapAction);
    } catch (WebServiceIOException | SSLPeerUnverifiedException ex) {
        if (retryAttempt) {
            logAndThrowExceptionUponWsRequest(ex);
        } else {
            LOGGER.info("Re-trying webservice-request");
            cleanConnections();
            result = performWsRequestWithRetry(request, soapAction, true);
        }
    } catch (Exception e) {
        logAndThrowExceptionUponWsRequest(e);
    }
...

private synchronized void cleanConnections() {

    LOGGER.info(
            "Cleaning connections. Total message-senders: {}",
            this.webServiceTemplate.getMessageSenders().length);

    for (WebServiceMessageSender messageSender : this.webServiceTemplate.getMessageSenders()) {

        if (messageSender instanceof HttpComponentsMessageSender) {

            LOGGER.info("Checking connections of message-sender {}", messageSender);
            HttpComponentsMessageSender httpComponentsMessageSender = (HttpComponentsMessageSender)messageSender;

            if (httpComponentsMessageSender.getHttpClient() != null
                && httpComponentsMessageSender.getHttpClient().getConnectionManager() != null) {
                LOGGER.info("Closing connections");
                httpComponentsMessageSender.getHttpClient().getConnectionManager().closeExpiredConnections();
                httpComponentsMessageSender.getHttpClient()
                        .getConnectionManager()
                        .closeIdleConnections(5000, TimeUnit.MILLISECONDS);
            }
        }
    }
}