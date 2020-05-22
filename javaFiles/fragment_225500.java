package forum10531285;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlType(name = "SubElement", propOrder = { "a", "b", "problemElement" })
@XmlAccessorType(XmlAccessType.FIELD)
public class SubElement {

    @XmlElement(required = true)
    private String a;

    @XmlElement(required = true)
    private String b;

    @XmlElementWrapper(name="problemElement")
    @XmlElement(name="option")
    private List<ProblemElement> problemElement = new ArrayList<ProblemElement>();

}