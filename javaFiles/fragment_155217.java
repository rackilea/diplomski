public class MyClass { 

    // constructor 
    public MyClass(arg1, arg2, arg3) { 
      // do some construction 
    } 
} 

public class MyClassFactory { 

    public static MyClass MakeMyClass(arg1, arg2, arg3) { 
      return new MyClass(arg1, arg2, arg3);
    } 

    public static MyClass MakeMyClass(arg1) { 
      // do some stuff to calculate arg2 and arg3 
      return new MyClass(arg1, arg2, arg3);
    } 
}