import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.*;

@XmlNamedObjectGraph(
    name = "simple", 
    attributeNodes = {
        @XmlNamedAttributeNode("firstName"), 
        @XmlNamedAttributeNode("lastName")
     }
)
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    private int clientId;
    private String firstName;
    private String lastName;
    private String email;

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}