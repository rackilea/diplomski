public abstract class ClassA<ClassBType extends ClassB> {
    public void method(ClassB type) {
        type.myClassA = this; 
    }
}

public abstract class ClassB {
    ClassA<? extends ClassB> myClassA;

    private void testMethod() {
        myClassA.method(this);
    }
}