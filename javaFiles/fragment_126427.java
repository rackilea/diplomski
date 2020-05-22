import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.*;

@XmlRootElement 
@XmlNamedObjectGraph(
    name="deleted",
    attributeNodes = { 
        @XmlNamedAttributeNode("objectId"),
        @XmlNamedAttributeNode("status")
    }
)
public class ClassA {

    public long objectId;
    public String status;
    public String property1;

}