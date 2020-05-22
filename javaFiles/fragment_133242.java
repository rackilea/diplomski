package nov18;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="FosterHome")
@XmlAccessorType(XmlAccessType.FIELD)
public class FosterHome {

    @XmlElement(name="Orphanage")
    private String orphanage;

    @XmlElement(name="Location")
    private String location;

    @XmlElementWrapper(name="Families")
    @XmlElement(name="Family")
    private List<Family> families;

    @XmlElementWrapper(name="RemainingChildList")
    @XmlElement(name="ChildID")
    private List<String> remainingChildren;

}