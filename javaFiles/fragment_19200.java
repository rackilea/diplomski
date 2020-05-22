public abstract class MySuperclass {
    public abstract void mySubclassMethod();
    ...
}

public class MySubclass extends MySuperclass {
    @Override
    public void mySublcassMethod() { ... }
    ...
}
...

MySuperclass obj = [actually a Subclass];
obj.mySubclassMethod(); // uses the implementation from MySubclass