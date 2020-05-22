import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="query")
@XmlAccessorType(XmlAccessType.FIELD)
public class Stock {

    @XmlElementWrapper(name="results")
    @XmlElement(name="quote")
    private List<Quote> quotes;

}