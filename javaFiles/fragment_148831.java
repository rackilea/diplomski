@XmlRootElement(name = "FooElement")
public class Foo {

    @XmlElement()
    @XmlJavaTypeAdapter(BooleanToEmptyObjectAdapter.class)
    private final Boolean isPresent = false;

    ...        
}