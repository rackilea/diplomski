public abstract class AbstractCar implements Car{
   ...
  public final void start(){
    state=...;
    doOnStart();
    state=...;
  }
  ...
}