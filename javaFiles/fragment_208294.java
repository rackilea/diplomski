//making the class abstract forces the dev to subclass it but not to override any method,
//which might not be necessary anyways.
public abstract class MainController{
  public void run() { }
  public void run(String command) {}
}

public class Sub1Controller extends MainController{
  @Override
  public void run(){  /*override only this method*/  }
}