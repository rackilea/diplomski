public interface IAbstract { }
public class A implements IAbstract { }
public class C implements IAbstract { }

// The factory interface that creates concrete implementations of IAbstract.
public interface IAbstractFactory {
    public IAbstract create();
}

public class AFactory implements IAbstractFactory {
    public IAbstract create() {
        return new A();
    }
} 

public class BFactory implements IAbstractFactory {
    public IAbstract create() {
        return new B();
    }
}