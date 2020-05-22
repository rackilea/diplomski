package forum7851052;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StringChild extends Parent<String> {

    @Override
    @XmlElement
    public List<String> getItem() {
        return super.getItem();
    }

    @Override
    public void setItem(List<String> item) {
        super.setItem(item);
    }

}