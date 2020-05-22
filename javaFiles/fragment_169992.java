import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlClassExtractor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Bird.class, Cat.class, Dog.class})
@XmlClassExtractor(AnimalExtractor.class)
public abstract class Animal {

    private String name;

}