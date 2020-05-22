public Receive createReceive() {
    return both(
            receiveBuilder()
                    .match(Foo.class, this::processFoo)
                    .match(Bar.class, this::processBar)
                    .match(Bash.class, this::processBash)
                    .match(OtherThing.class, this::processOtherThing),
            receiveBuilder().matchAny(this::doSomethingForAllMessages)
    ).build();
}

ReceiveBuilder both(ReceiveBuilder left, ReceiveBuilder right) {
    return ReceiveBuilder.create().matchAny(it -> Stream.of(left,right)
            .map(ReceiveBuilder::build)
            .map(Receive::onMessage)
            .forEach(action->action.apply(it)));
}