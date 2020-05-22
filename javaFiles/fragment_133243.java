package nov18;

import java.util.List;   
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Family {

    @XmlElement(name="ParentID")
    private String parentID;

    @XmlElementWrapper(name="ChildList")
    @XmlElement(name="ChildID")
    private List<String> childList;

}