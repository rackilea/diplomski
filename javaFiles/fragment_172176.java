class MyActor extends AbstractActor {
  public MyActor(ActorRef someOther) {
    final Props props = Props.create(SomeActor.class);
    final PartialFunction<Object, BoxedUnit> behavior =
      ReceiveBuilder
        .match(String.class, s -> getContext().actorOf(props, s))
        .build();

    receive(ReceiveBuilder
      .matchAny(x -> someOther.tell(behavior, self()))
      .build()
    );
  }
}