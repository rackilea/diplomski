public Receive createReceive() {
    return AcceptableReceiveBuilder.create()
                  .match(Foo.class, this::processFoo)
                  .match(Bar.class, this::processBar)
                  .match(Bash.class, this::processBash)
                  .match(OtherThing.class, this::processOtherThing)
                  .thenAccept(this::doSomethingForAllMessages)
                  .build();
}



class AcceptableReceiveBuilder extends ReceiveBuilder {
    private List<FI.UnitApply<Object>> afterActions = new ArrayList<>();

    public static AcceptableReceiveBuilder create() {
        return new AcceptableReceiveBuilder();
    }

    @Override
    public
    <P> AcceptableReceiveBuilder match(Class<P> type, FI.UnitApply<P> action) {
        return this.matchUnchecked(type, action);
    }

    @Override
    public
    AcceptableReceiveBuilder matchUnchecked(Class<?> type,
                                            FI.UnitApply<?> action) {
        return (AcceptableReceiveBuilder) super.matchUnchecked(type
                , compose(action));
    }

    @Override
    public
    <P> AcceptableReceiveBuilder match(Class<P> type,
                                       FI.TypedPredicate<P> condition,
                                       FI.UnitApply<P> action) {
        return this.matchUnchecked(type, condition, action);
    }

    @Override
    public
    <P> AcceptableReceiveBuilder matchUnchecked(Class<?> type,
                                                FI.TypedPredicate<?> condition,
                                                FI.UnitApply<P> action) {
        return (AcceptableReceiveBuilder) super.matchUnchecked(type, condition
                , compose(action));
    }

    @Override
    public
    <P> AcceptableReceiveBuilder matchEquals(P value, FI.UnitApply<P> action) {
        return (AcceptableReceiveBuilder) super.matchEquals(value
                , compose(action));
    }

    @Override
    public
    <P> AcceptableReceiveBuilder matchEquals(P value,
                                             FI.TypedPredicate<P> condition,
                                             FI.UnitApply<P> action) {
        return (AcceptableReceiveBuilder) super.matchEquals(value, condition
                , compose(action));
    }

    @Override
    public
    AcceptableReceiveBuilder matchAny(FI.UnitApply<Object> action) {
        return (AcceptableReceiveBuilder) super.matchAny(compose(action));
    }

    private
    <P> FI.UnitApply<P> compose(FI.UnitApply<P> action) {
        return value -> {
            action.apply(value);
            for (FI.UnitApply<Object> it : afterActions) {
                it.apply(value);
            }
        };
    }

    public
    AcceptableReceiveBuilder thenAccept(FI.UnitApply<Object> action) {
        afterActions.add(action);
        return this;
    }
}