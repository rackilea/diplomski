import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNamedObjectGraph(
    name = "policy", 
    attributeNodes = {
        @XmlNamedAttributeNode(value = "userCreated", subgraph = "simple"),
        @XmlNamedAttributeNode("client") 
    }
)
public class Policy {

    private Person userCreated;
    private Person client;

    public void setUserCreated(Person userCreated) {
        this.userCreated = userCreated;
    }

    public void setClient(Person client) {
        this.client = client;
    }

}