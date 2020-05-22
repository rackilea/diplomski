public final boolean dispatch(final Message<?> message) {
    if (this.executor != null) {
        Runnable task = createMessageHandlingTask(message);
        this.executor.execute(task);
        return true;
    }
    return this.doDispatch(message);
}