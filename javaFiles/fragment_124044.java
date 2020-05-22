import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Map;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Parameters {

    @XmlJavaTypeAdapter(value = Adapter.class)
    private Map<String, String> parametersMap;

    // Getter and setter for parametersMap
}