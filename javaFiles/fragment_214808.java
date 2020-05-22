import java.util.Date;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlCustomizer;

@XmlRootElement
@XmlType(factoryClass=CommonFactory.class, factoryMethod="create")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlCustomizer(FactoryCustomizer.class)
public class Foo {

    private Date creationDate;
    private Bar bar;

    // Non-default constructor
    public Foo(Date creationDate) {
        this.creationDate = creationDate;
    }

}