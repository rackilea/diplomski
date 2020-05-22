@Named("AnotherActor")
@Scope("prototype")
class AnotherActor extends UntypedActor {

  // the service that will be automatically injected
  final AnotherService anotherService;

  @Inject
  public AnotherActor(@Named("AnotherService") AnotherService anotherService) {
    this.anotherService = anotherService;
  }    

  @Override
  public void onReceive(Object message) throws Exception {
    if (message == "doSomething") {
      anotherService.doSomething();
    } else {
      unhandled(message);
    }
  }
}