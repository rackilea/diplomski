import java.lang.reflect.Field;

public class Main {
  public static void main(String[] args) {
      SuperClass s = new SuperClass();
      ChildClass c = new ChildClass();
      s.superMethod();
      c.superMethod();
  }
}

class SuperClass {
    private static final String a = "Super";

    public void superMethod(){
      try{
        final Class<?> clazz = this.getClass();
        final Field fieldA = clazz.getDeclaredField("a");
        fieldA.setAccessible(true);

        final String value = (String)fieldA.get(null);

        System.out.println("SuperMethod: " + value);
      } catch (final NoSuchFieldException | IllegalAccessException ex){
        // Because reflection
        ex.printStackTrace();
      }
    }
}

class ChildClass extends SuperClass {
    private static final String a = "Child";
}