@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Teste", propOrder = {
    "date"
})
public class Teste {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected OffsetDateTime date;
    // getter and setter
}