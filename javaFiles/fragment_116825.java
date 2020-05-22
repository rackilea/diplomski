// Signature compatible with Supplier<Set<String>> 
private Set<String> fetchDataWithRetry() {
    final RetryingCallable<Set<String>> retryCallable = new RetryingCallable<>(retryStrategyToRetryOnDBException(), getDataFromDB());
    try {
        return retryCallable.call();
    } catch (Exception e) {
        log.error("Call to database failed", e);
        return Collections.emptySet();
    }
}

// Signature compatible with Consumer<Set<String>>
private void storeData(Set<String> data) {
    if (!data.isEmpty()) {
        // store data in a global hash map
    }
}