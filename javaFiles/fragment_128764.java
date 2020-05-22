package test;

public abstract class AbstractClass {

    public abstract String something();

    public void printConstructorsOfInstantiatingClass() {
        System.out.println(getClass().getDeclaredConstructors());
    }
}

package test;

public class ConcreteClass extends AbstractClass {
    @Override
    public String something() {
        return "concreteSomething";
    }
}

package test;

public class TestMain {
    public static void main(String[] args) {
        ConcreteClass cc = new ConcreteClass();
        cc.printConstructorsOfInstantiatingClass();
    }
}