public void publishFailSafeAfterSuccessfulTransaction(final String routingKey, final String event) {

    TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
        @Override
        public void afterCommit() {
            try {
                publishFailSafe(routingKey, event);
            } catch (Exception exception) {
                //Do some recovering
            }
        }
    });
}