public interface InterfaceA {
    public Object clone();
}

public interface InterfaceB {}

public class ClassA<T extends InterfaceA> {} // ok

public class ClassB<T extends InterfaceA & InterfaceB> {} //not ok