public class MyIDManager {
  public static final ThreadLocal<Long> myID = new ThreadLocal<Long>();
}

...
// set ID at some point
MyIDManager.myID.set(theNewID);

...
// read it later
long currentID = MyIDManager.get();