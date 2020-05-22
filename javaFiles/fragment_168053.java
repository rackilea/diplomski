public class NamedImpl extends AnnotationLiteral<Named> implements Named {
    private final String name;

    public NamedImpl(String name) {
        this.name = name;
    }

    @Override
    public String value() {
        return name;
    }

    public String toString() {
        return "@Named(" + name + ")";
    }

}