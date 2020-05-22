@XmlRootElement(name = "net")
@XmlAccessorType(XmlAccessType.FIELD)
class Net {

    @XmlElement(name = "node")
    private List<Node> nodes;

    // getters, setters, toString
}

@XmlAccessorType(XmlAccessType.FIELD)
class Node {

    @XmlAttribute
    private String label;

    // getters, setters, toString
}