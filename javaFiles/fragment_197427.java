import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xx")
public class XMLXx implements Serializable {

    private static final long serialVersionUID = 4064597372833234503L;

    private List<XMLSite> sites;

    @XmlElement(name="s")
    public List<XMLSite> getSites() {
        return sites;
    }

    public void setSites(List<XMLSite> sites) {
        this.sites = sites;
    }

}