private Message<?> pollForMessage() {
    try {
        return this.pollingTask.call();
    }
    catch (Exception e) {
        if (e instanceof MessagingException) {
            throw (MessagingException) e;
        }
        else {
            Message<?> failedMessage = null;
            if (this.transactionSynchronizationFactory != null) {
                Object resource = TransactionSynchronizationManager.getResource(getResourceToBind());
                if (resource instanceof IntegrationResourceHolder) {
                    failedMessage = ((IntegrationResourceHolder) resource).getMessage();
                }
            }
            throw new MessagingException(failedMessage, e); // NOSONAR (null failedMessage)
        }
    }
    finally {
        if (this.transactionSynchronizationFactory != null) {
            Object resource = getResourceToBind();
            if (TransactionSynchronizationManager.hasResource(resource)) {
                TransactionSynchronizationManager.unbindResource(resource);
            }
        }
    }
}