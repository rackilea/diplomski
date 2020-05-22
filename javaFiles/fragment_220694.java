public class ChildClass implements A, C {
    @Override    
    public void foo() {
       //you could completely override the default implementations
       doSomethingElse();
       //or manage conflicts between the same method foo() in both A and C
       A.super.foo();
    }
    public void bah() {
       A.super.foo(); //original foo() from A accessed
       C.super.foo(); //original foo() from C accessed
    }
}