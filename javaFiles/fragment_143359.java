public abstract class AbstractTest {
  private String abstractString = "abstract";
  public void showFields() throws IllegalAccessException {
    for (Field field : this.getClass().getSuperclass().getDeclaredFields()) {
      try {
        System.out.println(field.get(this));
      }
      catch (IllegalAccessException e) { 
        // swallow 
      }
    }
  }
}

public class MyTest extends AbstractTest
{
  private String concreteString = "concreteString";
  @Override public void showFields() throws IllegalAccessException {
    for (Field field : this.getClass().getDeclaredFields()) {
      try {
        System.out.println(field.get(this));
      }
      catch (IllegalAccessException e) {  
        // swallow
      }
    }
    super.showFields();
  }
}