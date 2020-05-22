public interface MyInterface<T> {
   public T myMethod(T other);
   ...
}

public class MyClass implements MyInterface<MyClass> {
   // has to reference this class in the implementation
   public MyClass myMethod(MyClass other){
      ...
   } 
}