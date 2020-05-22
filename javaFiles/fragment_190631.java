private final AtomicBoolean invoked = new AtomicBoolean();

    public Date nextExecutionTime(TriggerContext triggerContext) {
        return this.invoked.getAndSet(true) ? null : new Date();
    }

...

    e -> e.poller(p -> p.trigger(this::nextExecutionTime))