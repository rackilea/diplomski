public class MyClass implements MyInterface {

    private MyInterface my1;

    public MyClass(MyInterface someValue) {
        my1 = someValue;
    }

    public void display() {
        my1.display();
    }

}