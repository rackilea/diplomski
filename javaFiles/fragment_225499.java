package forum10531285;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "root")
@XmlType(name = "Root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlElement(name = "subElement", required = true)
    private final List<SubElement> subElementList = new ArrayList<SubElement>();

}