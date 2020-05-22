public interface Events{
  public void randomEvent();
}

public abstract class MainActivity implements Events{

}

public class RandomEvent extends MainActivity{
  @Override
 public void randomEvent() {
    //You stuff
 } 
}