import javax.xml.bind.annotation.XmlSeeAlso;
import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

@XmlSeeAlso({Bird.class, Cat.class, Dog.class})
@XmlDiscriminatorNode("@type")
abstract class Animal {

    public String name; 

}