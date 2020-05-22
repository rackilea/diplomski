package forum7851052;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IntegerChild extends Parent<Integer> {

    @Override
    @XmlElement
    public List<Integer> getItem() {
        return super.getItem();
    }

    @Override
    public void setItem(List<Integer> item) {
        super.setItem(item);
    }

}