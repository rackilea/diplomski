public abstract class ClassA{

    public abstract ClassA getClassOfSameKind();

}

public abstract class ClassB extends ClassA{

    @Override
    public abstract ClassB getClassOfSameKind();

    public void doSomethingSpecial(){
        ClassB otherClass = this.getClassOfSameKind();
        //do something special that only Class B can do
    }

}

public class ClassC extends ClassB {
    @Override
    public ClassC getClassOfSameKind() {
        return new ClassC();
    }
}