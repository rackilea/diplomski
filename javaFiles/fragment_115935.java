public interface Events{
  public void randomEvent();
}
public class MainActivity{
      public Events getEvents(){
        return null;
      }

      public void randomTrigger(){

            Events events = getEvents();
            if(null != events){
               events.randomEvent();
            }
        }


    }
    }

public class RandomEvent extends MainActivity implements Events{
  @Override
 public void randomEvent() {
    //You stuff
 }
 @Override
 public Events getEvents(){
    return this;
  } 
}