public class SuperClass {
    public void methodToOverride(){
        System.out.println("Some text");
    }
}

public abstract class SubClass extends SuperClass{
    public abstract void methodToOverride();
}

public class OtherClass extends SubClass {
    @Override
    public void methodToOverride() {
        // new logic
    }
}