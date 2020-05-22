public class MyClass<T extends Number>{


  public T getValue(){
    //do something here
  }
}

MyClass<Integer> foo = new MyClass<Integer>();
foo.getValue()+5;