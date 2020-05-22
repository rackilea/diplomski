abstract class A {

    public void doSomething() {
        // basic things to do

        // then call implementation
        doSomethingImpl();
    }

    protected abstract void doSomethingImpl();
}

class B extends A {

    @Override
    protected void doSomethingImpl() {
        //extended functionality
    }
}

class C extends A {  // does not compile

}