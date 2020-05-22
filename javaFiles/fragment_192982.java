import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlTransient
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(Foo.class)
abstract class Wrapper<T> {

    @XmlAttribute
    @XmlJavaTypeAdapter(ObjectAdapter.class)
    private T value;

    Wrapper() {} // default ctor for JAXB

    public Wrapper(T t) {
        value = t;
    }

}