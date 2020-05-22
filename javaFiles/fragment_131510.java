public interface Identifiable {
    /**
     * returns the ID of the resource, that must unique among all the resources
     */
    public String getId();
}

public class SomeClass
    public void someMethod(Identifiable identifiable) {
        // some code that uses identifiable.getId()
    }
}