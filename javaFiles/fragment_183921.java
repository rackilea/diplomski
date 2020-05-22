public class AddressHandler implements Handles<Event>{
    public void handle(Event e){
      if(e instanceof AddressDiscarded){
         handleDiscarded(e);
      } else if(e instanceof AddressChanged){
         handleChanged(e);
      }
    }
    public void handleDiscarded(AddressDiscarded e){}
    public void handleChanged(AddressChanged e){}
}