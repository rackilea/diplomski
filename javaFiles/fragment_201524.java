@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name= "A")
public class A {
    @XmlElements({
            @XmlElement(name="b", type = B.class),
            @XmlElement(name="c", type = C.class),
            @XmlElement(name="d", type = D.class),
    })
    List<Letter> letters;

    public A() {}

    public A(final List<Letter> letters) {
        this.letters = letters;
    }
}