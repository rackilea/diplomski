final ActorRef cacheSender = getSender();
Future<List<Object>> futureStatuses = sequence(statuses, ...);
futureStatuses.onComplete( new Procedure2<Throwable, List<Object>>() {
  public void apply(Throwable t, Object r) {
    if(t != null) cacheSender.tell("ohnoes");
    else cacheSender.tell(r);
  }
});