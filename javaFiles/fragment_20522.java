@Singleton
public class MemcachedPoolService{

  @AccessTimeout(Integer.MORE_THAN_5000_MILLIS)
  public void myPossibleMultiAccessMethod(){}
}