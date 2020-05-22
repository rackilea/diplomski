class A{
@Override //gives you an error
public void doSomething(){}
}

class B extends A {

@Override //cool here!
public void doSomething(){}

@Override  //error as well
public void doAnotherThing(){}
}