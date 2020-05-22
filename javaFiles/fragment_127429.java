@XmlRootElement(name = "getOrder", namespace = "http://www.example.org/order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getOrder", namespace = "http://www.example.org/order")

public class GetOrder {

    @XmlElement(name = "id")
    private java.lang.String id;