public class SomeExample {

  public static void main(String[] args) throws Exception{
    Object myObj = new SomeDerivedClass(1234);
    Class myClass = myObj.getClass();
    Field myField = getField(myClass, "value");
    myField.setAccessible(true); //required if field is not normally accessible
    System.out.println("value: " + myField.get(myObj));
  }

  private static Field getField(Class clazz, String fieldName)
        throws NoSuchFieldException {
    try {
      return clazz.getDeclaredField(fieldName);
    } catch (NoSuchFieldException e) {
      Class superClass = clazz.getSuperclass();
      if (superClass == null) {
        throw e;
      } else {
        return getField(superClass, fieldName);
      }
    }
  }
}

class SomeBaseClass {
  private Integer value;

  SomeBaseClass(Integer value) {
    this.value = value;
  }
}

class SomeDerivedClass extends SomeBaseClass {
  SomeDerivedClass(Integer value) {
    super(value);
  }
}