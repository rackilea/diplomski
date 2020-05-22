package forum10174513;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Root {

    private List<BaseBean> baseBeans;

    @XmlElement(name="base-bean", type=BaseBeanEx.class)
    public List<BaseBean> getBaseBeans() {
        return baseBeans;
    }

    public void setBaseBeans(List<BaseBean> baseBeans) {
        this.baseBeans = baseBeans;
    }

}