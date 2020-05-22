import java.io.Serializable;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({SourceDataFile.class, ExtensionDataFile.class})
@XmlDiscriminatorNode("@role")
public abstract class BaseDataFile implements Serializable {

}