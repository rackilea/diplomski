import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlDiscriminatorValue("source")
public class SourceDataFile extends BaseDataFile {

}