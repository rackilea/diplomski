@Override
public Receive createReceive() {
    return receiveBuilder()
        .match(StartNewTimer.class, message -> {
            getTimers().startPeriodicTimer(/* blah whatever */);
        })
        .build();
}