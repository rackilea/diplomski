public class MyClass {

    private int myPrivateInt;

    public void example (MyClass m) {
        int x = m.myPrivateInt; // <- OK, we are in MyClass 
    }        

}

public class SomewhereElse {

    public void example (MyClass m) {
        int x = m.myPrivateInt; // <- not allowed
    }

}