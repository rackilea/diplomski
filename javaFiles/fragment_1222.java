class MyRouter extends UntypedActor {
  final Set<ActorRef> subscribers = new HashSet<ActorRef>();

  @Override public void onReceive(Object msg) {
    if (msg instanceof Subscribe) {
      subscribers.add(getSender());
    } else if (msg instanceof Unsubscribe) {
      subscribers.remove(getSender());
    } else {
      for (ActorRef target: subscribers) {
        target.tell(msg, getSender());
      }
    }
  }
}