import java.util.Date;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlCustomizer;

@XmlType(factoryClass=CommonFactory.class, factoryMethod="create")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlCustomizer(FactoryCustomizer.class)
public class Bar {

    private Date creationDate;

    // Non-default constructor
    public Bar(Date creationDate) {
        this.creationDate = creationDate;
    }

}