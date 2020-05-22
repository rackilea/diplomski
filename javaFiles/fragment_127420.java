package forum13941747;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Payload", propOrder = {
    "any"
})
public class Payload {

    @XmlAnyElement(lax = true)
    protected List<Object> any;

}