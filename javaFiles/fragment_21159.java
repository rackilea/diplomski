import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="thing")
public class Thing{
    private String name;
    private boolean awesome;

    @XmlValue public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }


    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    public void setAwesome(boolean awesome) {
        this.awesome = awesome;
    }
    public boolean isAwesome() {
        return this.awesome;
    }
}