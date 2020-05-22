@XmlRootElement(name = "customer")
class Customer {
    @XmlElement  
    String name;

    @XmlElement
    Integer pin;