@PersistenceCapable
public class SomeClass {
    @Serializable
    private Map<String, List<SomeOtherClass>> myAttribute;
    // ...
}

@PersistenceCapable(embeddedOnly="true")
public class SomeOtherClass implements Serializable {
    private String attribute;
    // ...
}