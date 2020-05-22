@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Element{};

@XmlAccessorType(XmlAccessType.FIELD)
public class FirstElement extends Element{ ... };

@XmlAccessorType(XmlAccessType.FIELD)
public class SecondElement extends Element{ ... };

//Other elements classes

@XmlRootEntity
@XmlAccessorType(XmlAccessType.FIELD)
public class HeadTag{
    @XmlElements({
        @XmlElement(name="firstElement",type=FirstElement.class),
        @XmlElement(name="secondElement",type=SecondElement.class),
        //One for each of your classes
    })
    private List<Element> elements;
}