public class MyClass<T> {

    public final CustomClass<T> customClass;

    public MyClass( Class<T> clazz) {
      customClass = new CustomClass<T>(clazz);   
    }

 }