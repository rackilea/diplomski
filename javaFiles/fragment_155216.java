public class MyClass { 

    // first constructor 
    public MyClass(arg1, arg2, arg3) { 
      init(arg1, arg2, arg3); 
    } 

    // second constructor 
    public MyClass(int arg1) { 
      // do some stuff to calculate arg2 and arg3 
      init(arg1, arg2, arg3); 
    } 

    private init(int arg1, int arg2, int arg3) {
      // do some construction 
    }
}