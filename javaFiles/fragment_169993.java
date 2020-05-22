import javax.xml.bind.annotation.XmlAttribute;

public class Bird extends Animal {

    @XmlAttribute
    private String wingSpan;

    @XmlAttribute
    private String preferredFood;

}