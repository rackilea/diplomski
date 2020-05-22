import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlAccessorType(XmlAccessType.FIELD)
public class Step {

    @XmlID
    @XmlAttribute
    private String id;

    @XmlPath("DetailPanelReference/@reference")
    @XmlIDREF
    // private List<DetailPanel> _detailPanels; // WORKS
    private DetailPanel[] _detailPanels; // See bug:  http://bugs.eclipse.org/399293

}