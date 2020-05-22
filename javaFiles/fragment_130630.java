public interface A {  
    default void foo(){  
        System.out.println("Calling A.foo()");  
    }  
}

public interface B {
    default void foo(){
        System.out.println("Calling B.foo()");
    }
}


public class ClassAB implements A, B {

}