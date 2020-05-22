@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public static class UseInterface {

    @XmlAnyElement
    private org.w3c.dom.Element foo;

    @XmlTransient
    private SomeInterface ifc


    public void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        NamedNodeMap attributes = foo.getAttributes();
        // do something with foo on DOM level to bind the subtree to an interface manually
    }
}