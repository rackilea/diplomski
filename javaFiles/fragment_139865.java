public class Super {
    private final String name;

    Super() {
        name = "default";
    }

    public String name() {
        return name.toUpperCase();
    }
}

public class Sub extends Super {
    public Sub() {
        // don't do anything
    }
}