public interface MyInterface {
    List<? extends Superclass> getList();
}

public class Superclass {}
public class Subclass {}

public class MyClass implements MyInterface {
    public List<? extends Superclass> getList() {
        return new ArrayList<SubClass>();
    }
}