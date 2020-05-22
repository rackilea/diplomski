//Note that I used T instead of Data to reduce confusion
//Data looks a lot like an actual class name
public abstract class DataContainer<T>{
  public DataContainer(String method) throws NoSuchMethodException, SecurityException {
    Class<?> actualClass = getActualTypeForT();
    //use reflection to get the method from actualClass and call it
  }

  protected Class<?> getActualTypeForT() {
    //get the generic boundary here, for details check http://www.artima.com/weblogs/viewpost.jsp?thread=208860
  } 
} 

//A concrete subclass to provide the actual type of T for reflection, can be mostly empty
public class SomeClassContainer extends DataContainer<SomeClass> {
  //constructor etc.
}