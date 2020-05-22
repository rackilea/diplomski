public class Superclass<T extends Superclass<T>> {
    @SuppressWarnings("unchecked")
    private final T thisAsT = (T) this;

    T someMethodThatDoesSameThingForAllSubclasses() {
       return thisAsT;
    }
}

public class Subclass extends Superclass<Subclass> {
    Subclass subclassOnlyMethod() {
        return this;
    }
}