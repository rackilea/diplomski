@Singleton
public class MemcachedPoolService{

  @Lock(LockType.READ)
  public void myPossibleMultiAccessMethod(){}
}