package forum383861;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="release-group")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReleaseGroup {

    @XmlAttribute
    String type;

    String title;

}