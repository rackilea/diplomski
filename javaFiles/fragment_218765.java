import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="SummaryCart", namespace="SummaryCart")
@XmlAccessorType(XmlAccessType.FIELD)
public class SummaryCart{

    @XmlElement(name="SummaryElement")
    private List<SummaryElement> summaryElementList;

}