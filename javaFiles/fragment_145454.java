Receive createReceive() {
    return thenAccept(
            receiveBuilder()
                    .match(Foo.class, this::processFoo)
                    .match(Bar.class, this::processBar)
                    .match(Bash.class, this::processBash)
                    .match(OtherThing.class, this::processOtherThing)
                    .build(),
            this::doSomethingForAllMessages
    );
}

<T> Receive thenAccept(Receive origin, FI.UnitApply<T> action) {
    return new Receive(thenAccept(origin.onMessage(), action));
}

<A, B> PartialFunction<A, B> thenAccept(PartialFunction<A, B> fn,
                                    FI.UnitApply<A> action) {
    return Function.unlift(thenAccept(fn.lift(), action));
}

<A, B> Function1<A, Option<B>> thenAccept(Function1<A, Option<B>> fn,
                                      FI.UnitApply<A> action) {
    return it -> {
        Option<B> value = fn.apply(it);
        action.apply(it);
        return value;
    };
}