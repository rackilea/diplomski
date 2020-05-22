import java.io.Serializable;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;
import org.eclipse.persistence.oxm.annotations.XmlReadOnly;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({SourceDataFile.class, ExtensionDataFile.class})
@XmlDiscriminatorNode("@role")
public abstract class BaseDataFile implements Serializable {

    @XmlAttribute
    @XmlReadOnly
    String role;

}