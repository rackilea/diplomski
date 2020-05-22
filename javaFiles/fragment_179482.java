public class A {
    protected ClassX a

    public void foo() {
        // operations on a;
    }
}

public class B extends A {
    // do something to set an instance of ClassY to a; for example...
    public void setClassY(ClassY b){
        this.a = b;
    }
}