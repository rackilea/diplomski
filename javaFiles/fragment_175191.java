package forum17988539;

import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name="evec_api")
@XmlAccessorType(XmlAccessType.FIELD)
public class MarketStatObject {

    @XmlPath("marketstat/type/@id")
    private int id;

    @XmlPath("marketstat/type/buy")
    private MarketStatObjectStats buy;

    @XmlPath("marketstat/type/sell")
    private MarketStatObjectStats sell;

    @XmlPath("marketstat/type/all")
    private MarketStatObjectStats all;

}