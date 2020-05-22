package forum11599191;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

    @XmlAttribute
    private int id;

    private String firstName;

    @XmlElement(nillable=true)
    private String lastName;

    private List<String> email;

}