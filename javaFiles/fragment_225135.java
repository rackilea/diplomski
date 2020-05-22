import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class Root {

    private Map<String, Integer> mapProperty;

    public Root() {
        mapProperty = new HashMap<String, Integer>();
    }

    @XmlJavaTypeAdapter(MapAdapter.class)
    public Map<String, Integer> getMapProperty() {
        return mapProperty;
    }

    public void setMapProperty(Map<String, Integer> map) {
        this.mapProperty = map;
    }

}