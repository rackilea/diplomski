class SomeClass {

    public SomeClass() {

        doSomething();//Warning - Overridable method call in constructor
        SomeClass.this.doSomething();//Seems OK, but is not
    }

    public void doSomething() {
        System.out.println("parent");
    }
}

public class SomeOtherClass extends SomeClass {
    @Override
    public void doSomething() {
        System.out.println("child");
    }

    public static void main(String[] args) {
        SomeClass a = new SomeClass();
        SomeOtherClass b = new SomeOtherClass();
    }
}