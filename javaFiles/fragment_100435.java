@XmlRootElement(name="someRootElement", namespace = "urn:my:ns1")
class Test {
    @XmlElement(name="someElement", namespace="urn:my:ns1")
    String elem1 = "One";

    @XmlElement(name="someElement", namespace="urn:my:ns2")
    String elem2 = "Two";

    @XmlElement(name="someElement", namespace="urn:my:ns3")
    String elem3 = "Three";
}