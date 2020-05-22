public abstract class AbstractCar implements Car{
   ...
  public abstract State getStateBeforeStart();
  public abstract State getStateAfterStart();
  ...
  public final void start(){
    state = getStateBeforeStart();
    doOnStart();
    state = getStateAfterStart();
  }
  ...
}