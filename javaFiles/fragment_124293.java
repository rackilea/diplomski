// parent
public class Parent {
    private int value = 0;
    public Parent( int initialValue ) {
        value = initialValue;
    }

    public void print() {
        System.out.println(value);
    }
}

// child class
public class Child extends Parent{
    public Child() {
       super( 1 ); /// This super keyword change your parent class variable.
    }
}