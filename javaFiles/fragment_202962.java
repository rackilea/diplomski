public class A implements ChangeListener {

public A() {
    myB = new B();
    myB.setChangeListener(this);
}

...

public void onChangeHappened() {
    // do something with B now that you know it has changed.
}