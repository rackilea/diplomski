public class MyClass<T> extends SomeClass<T>{

  public T someMethod(){
     // T could be any type. Could be Word, could be String, ......
     T someObject = super.getItem();
     return someObject
  }

}