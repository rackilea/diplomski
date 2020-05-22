package forum20745762;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="SmMessageSet")
@XmlAccessorType(XmlAccessType.FIELD)
public class SmMessageSet {

    @XmlElementWrapper
    @XmlElementRef
    private List<SmMessage> smMessages;

}