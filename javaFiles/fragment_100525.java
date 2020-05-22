@XmlElementRefs({
    @XmlElementRef(name = "sub", namespace = "urn:some:namespace", type = JAXBElement.class),
    @XmlElementRef(name = "someclass", namespace = "urn:some:namespace", type = JAXBElement.class)
})
@XmlMixed
protected List<Object> content;