public abstract class Parent {
    private String name;

    public static <T extends Parent> T defaultParent(Supplier<T> constructor) {
        T parent = constructor.get();
        //fill default field values
        parent.name = "default name";
        return parent;
    }
}

public class Child extends Parent {

}