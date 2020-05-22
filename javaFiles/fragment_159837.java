package forum11334385;

import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name="A")
@XmlAccessorType(XmlAccessType.FIELD)
class B {

    @XmlPath("B/C/D/text()")
    private String D;

    @XmlPath("B/C/E/text()")
    private String E;

}