@PersistenceCapable
public class SomeClass {
    private Map<String, SomeOtherClassContainer> myAttribute;
    // ...
}

@PersistenceCapable(embeddedOnly="true")
public class SomeClassContainer {
    private List<SomeOtherClass> myAttribute;
    // ...
}

@PersistenceCapable(embeddedOnly="true")
public class SomeOtherClass {
    private String attribute;
    // ...
}