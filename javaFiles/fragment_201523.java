@XmlRootElement(name="A")
@XmlAccessorType(XmlAccessType.FIELD)
public class A {

    @XmlElements({
            @XmlElement(name="b", type = String.class),
            @XmlElement(name="c", type = String.class),
            @XmlElement(name="d", type = String.class),
    })
    private List<String> letters;
}