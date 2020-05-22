@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ABWrap")
public class ABWrap {
    @XmlElements({
            @XmlElement(name="A", type = A.class),
            @XmlElement(name="B", type = B.class),
    })
    private List<Letter> letters;
}