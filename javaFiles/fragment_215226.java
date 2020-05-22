@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "root", propOrder = {
    "dateElement",
    "dateTimeElement",
    "extendedDateElement"
})
public class Root {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateElement;

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTimeElement;

    @XmlElement(required = true)
    protected XMLGregorianCalendar extendedDateElement;

    @XmlAttribute(name = "dateAttribute")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateAttribute;

    @XmlAttribute(name = "dateTimeAttribute")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTimeAttribute;

    @XmlAttribute(name = "extendedDateAttribute")
    protected XMLGregorianCalendar extendedDateAttribute;

}