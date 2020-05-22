class HappyEvent extends AbstractEvent{
  public static AbstractEvent.Key KEY = new AbstractEvent.Key(){...}

  public GwtEvent.Key getKey(){
    return KEY; 
  }
  ...
}