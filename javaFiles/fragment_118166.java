public abstract class ClassA<ClassBType extends ClassB> {
    public void method(ClassBType type) {
        type.myClassA = this; 
    }
}

public abstract class ClassB {
    ClassA<ClassB> myClassA;

    private void testMethod() {
        myClassA.method(this);
    }
}