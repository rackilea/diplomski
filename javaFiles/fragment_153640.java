import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Quote {

    @XmlElement(name="Date")
    @XmlSchemaType(name="date")
    private Date date;

    @XmlElement(name="Open")
    private double open;

    @XmlElement(name="High")
    private double high;

    @XmlElement(name="Low")
    private double low;

    @XmlElement(name="Close")
    private double close;

    @XmlElement(name="Volume")
    private long volume;

    @XmlElement(name="Adj_Close")
    private double adjClose;

}