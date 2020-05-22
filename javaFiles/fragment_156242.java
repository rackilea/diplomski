@Override
protected void handleMessageInternal(Message<?> message) throws Exception {
    Object correlationKey = this.correlationStrategy.getCorrelationKey(message);
...
    UUID groupIdUuid = UUIDConverter.getUUID(correlationKey);
    Lock lock = this.lockRegistry.obtain(groupIdUuid.toString());

    lock.lockInterruptibly();
    try {
    ...
    }
    finally {
        lock.unlock();
    }
}