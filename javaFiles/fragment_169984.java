import java.util.Collection;
import javax.xml.bind.annotation.XmlElementRef;

class Zoo {
    @XmlElementRef
    public Collection<? extends Animal> animals;
}