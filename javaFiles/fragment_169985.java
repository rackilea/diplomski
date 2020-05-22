import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Bird.class, Cat.class, Dog.class})
public abstract class Animal {

    private String name;

}