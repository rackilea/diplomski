import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="payTypeList")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayTypeList {

    @XmlElement
    private List<String> payType;

    public List<String> getPayType() {
        return payType;
    }

    public void setPayType(List<String> payType) {
        this.payType = payType;
    }
}