public abstract class Parent {
    private String name;

    public Parent(boolean useDefaults) {
        if (useDefaults) {
            //fill default field values
            this.name = "default name";
        }
    }
}

public class Child extends Parent {
    public Child(boolean useDefaults) {
        super(useDefaults);
    }

    public Child() {
        super(false);
    }
}