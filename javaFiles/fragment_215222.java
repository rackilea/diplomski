import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    protected XMLGregorianCalendar default1;

    protected XMLGregorianCalendar default2;

    @XmlSchemaType(name="date")
    protected XMLGregorianCalendar schemaTypeDate;

}