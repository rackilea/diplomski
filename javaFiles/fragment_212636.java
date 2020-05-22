package forum13595629;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "appConfig")
@XmlType(propOrder = {})
public class Config implements Serializable {

    private int advancedFooBar;

    @XmlElement(name = "advancedfoobar", type=Integer.class)
    public int getAdvancedFooBar() {
        return advancedFooBar;
    }

    public void setAdvancedFooBar(int advancedFooBar) {
        this.advancedFooBar = advancedFooBar;
    }

}