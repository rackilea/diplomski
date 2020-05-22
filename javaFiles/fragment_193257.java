public class ParentClass {
    public static String x;
    public ParentClass() {
        x = "In ParentClass";
    }
}

public class ChildClass extends ParentClass {
    public ChildClass() {
        x = "In ChildClass";
    }
}