package forum8986842;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="Root")
public class Root {

    private String item;

    @XmlElement(name = "Item", required = true, nillable = true)
    @XmlJavaTypeAdapter(StringAdapter.class)
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

}