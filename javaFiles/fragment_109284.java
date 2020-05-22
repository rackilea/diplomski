@JacksonXmlRootElement(localName = "customer") 
class Customer {

    @JacksonXmlProperty(localName = "id")
    private int id;
    @JacksonXmlProperty(localName = "name")
    private String  name;

    @JacksonXmlProperty(localName = "addresses")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Address[] address;

    //getters, setters, toString
}

class Address {

    @JacksonXmlProperty(localName = "city")
    private String city;

    @JacksonXmlProperty(localName = "state")
    private String state;
    // getter/setter 
}