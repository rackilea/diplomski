import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Bird.class, Cat.class, Dog.class})
@XmlDiscriminatorNode("@type")
public abstract class Animal {

    private String name;

}