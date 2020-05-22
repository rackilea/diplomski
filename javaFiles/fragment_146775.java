public class LabeledClass {

    private final String label;
    private final Class<?> theClass;

    LabeledClass(String label, Class<?> theClass) {
        this.label = Objects.requireNonNull(label);
        this.theClass = theClass;  // TODO null check?
    }

    public Class<?> getTheClass() {
        return theClass;
    }

    @Override
    public String toString() {
        return label;
    }

    // TOD hashcode, equals ?
}