public Receive createReceive() {
    return thenAccept(
            receiveBuilder()
                    .match(Foo.class, this::processFoo)
                    .match(Bar.class, this::processBar)
                    .match(Bash.class, this::processBash)
                    .match(OtherThing.class, this::processOtherThing),
            this::doSomethingForAllMessages
    ).build();
}

ReceiveBuilder thenAccept(ReceiveBuilder origin, FI.UnitApply<Object> action) {
    return ReceiveBuilder.create().matchAny(allOf(
            origin.build().onMessage()::apply,
            action
    ));
}

FI.UnitApply<Object> allOf(FI.UnitApply<Object>... actions) {
    return it -> {
        for (FI.UnitApply<Object> action : actions) {
            action.apply(it);
        }
    };
}