@Component
class ClassA {}

@Component
class ClassB extends ClassA {}

abstract class AbstractClass {
    protected ClassA classA;
}

@Component
class Class1 extends AbstractClass {
    public Class1(ClassA classA) {
        this.classA = classA;
    }
}
//... Same for Class2/3/4

@Component
class Class5 extends AbstractClass {
    public Class5(ClassB classB) {
        this.classA = classB;
    }
}