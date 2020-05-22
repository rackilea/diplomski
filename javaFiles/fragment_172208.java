import java.math.BigDecimal;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonTraining {

    @XmlElement(name = "Val1", required = true)
    protected BigDecimal val1;
    @XmlElement(name = "Val2", required = true, nillable = true)
    protected BigDecimal val2;
    @XmlElement(name = "Val3", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar val3;

}