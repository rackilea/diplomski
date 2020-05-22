package forum12323397;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Lists<VALUE> {

    private List<VALUE> values = new ArrayList<VALUE>();

    @XmlAnyElement(lax=true)
    public List<VALUE> getValues() {
        return values;
    }

}