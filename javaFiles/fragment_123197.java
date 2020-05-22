package forum15821738;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.*;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person implements Serializable {

    private String name;

    @XmlInverseReference(mappedBy="children")
    private Person parent;

    @XmlElementWrapper
    @XmlElement(name="child")
    private List<Person> children;

    public Person getParent() {
        return parent;
    }

    public List<Person> getChildren() {
        return children;
    }

    // OTHER GETTERS AND SETTERS

}