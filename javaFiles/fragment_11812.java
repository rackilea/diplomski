import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class Configuration {

    private List<Options> section = new ArrayList<Options>();

    @XmlJavaTypeAdapter(OptionsAdapter.class)
    public List<Options> getSection() {
        return section;
    }

    public void setSection(List<Options> section) {
        this.section = section;
    }

}