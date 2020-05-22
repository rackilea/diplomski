@XmlRootElement
public class SomeClass{ 
    @XmlElementWrapper
    @XmlElement(name="NestedClass")
    List<NestedClass> classes;
}