package forum8807296;

import java.util.List;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class Foo {
    private List<Bar> bars;

    @XmlElement(name="bar")
    @XmlJavaTypeAdapter(BarAdapter.class)
    public List<Bar> getBars() {
        return bars;
    }

    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }

}