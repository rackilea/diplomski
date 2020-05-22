@Named("CountingActor")
@Scope("prototype")
class CountingActor extends UntypedActor {

  public static class Count {}
  public static class Get {}

  // the service that will be automatically injected
  final CountingService countingService;

  @Inject
  public CountingActor(@Named("CountingService") CountingService countingService) {
    this.countingService = countingService;
  }

  private int count = 0;

  @Override
  public void onReceive(Object message) throws Exception {
    if (message instanceof Count) {
      count = countingService.increment(count);
      // Create AnotherActor here as a child of CountingActor by using the CountingActor's context
      ActorRef anotherActor = getContext().actorOf(SpringExtProvider.get(system).props("AnotherActor"), "another");
      anotherActor.tell("doSomething", getSelf());
    } else if (message instanceof Get) {
      getSender().tell(count, getSelf());
    } else {
      unhandled(message);
    }
  }
}