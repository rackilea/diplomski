public class SomeOtherClass extends SomeClass {
    @Override
    public void doSomething() { //compiler error
        System.out.println("child");
    }
    //...
}