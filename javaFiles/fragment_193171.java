import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name="type")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlPath(".")
    private Item item;

    @XmlPath(".")
    private ItemDimensions itemDimensions;

}