public abstract class AbstractFactory {
    public abstract SC sc();
}

public class ChildAFactory extends AbstractFactory {
    public SC sc(){ return new ChildA();}
}

public class ChildBFactory extends AbstractFactory {
    public SC sc(){ return new ChildB();}
}