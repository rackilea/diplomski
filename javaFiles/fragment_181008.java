@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Root")
class Root {

    @XmlElement(required = true, name = "ps")
    protected List<PropertySequence> propertySequence;

    // getters, setters, toString
}

@XmlAccessorType(XmlAccessType.FIELD)
class PropertySequence {

    @XmlElement(name = "p")
    protected List<Property> property;

    // getters, setters, toString
}


@XmlAccessorType(XmlAccessType.FIELD)
class Property {

    @XmlAttribute(name = "name", required = true)
    protected String name;

    @XmlAttribute(name = "vt", required = true)
    protected Integer vt;

    @XmlMixed
    @XmlAnyElement
    protected List<Object> value;

    // getters, setters, toString
}