private AtomicReference<ScheduledFuture<?>> scheduledRemoval;

public T get() { 
    ScheduledFuture<?> next = executor.schedule(() -> value.reset(), expirationDelay, timeUnit);
    ScheduledFuture<?> current = scheduledRemoval.getAndSet( next );
    if (current != null) {
            current.cancel(true);
    }

    T returnVal = value.get();

    return returnVal;
}