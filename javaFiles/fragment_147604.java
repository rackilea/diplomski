public interface MyInterface 
{ 
    void theMethod(); 
} 

public abstract class MyAbstractClass : MyInterface 
{ 
     public abstract void theMethod();
} 

public class MyClass : MyAbstractClass 
{ 
    public override void theMethod() 
    { 
        /* Implement missing interface methods in this class. */ 
    } 
}