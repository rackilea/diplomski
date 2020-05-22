class ControllerStartStop  {
  @Inject
  private MainDay mDay;

  ...
  public String startCircle(String passwordP, String passwordH) {
    ...
    String res = "some msg";
    webEvent.fire(new SomeWebMessage(res, 0)); 
    mDay.startDay();    
    ...
  }