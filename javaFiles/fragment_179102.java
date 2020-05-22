import java.lang.reflect.ParameterizedType;
  public abstract class Test<T extends A> {

     private Class<T> theType;

     public Test()  {
        theType = (Class<T>) (
               (ParameterizedType) getClass().getGenericSuperclass())
              .getActualTypeArguments()[0];
     }

     // this method will always return the type that extends class "A"
     public Class<T> getTheType()   {
        return theType;
     }

     public void printType() {
        Class<T> clazz = getTheType();
        System.out.println(clazz);
     }
  }