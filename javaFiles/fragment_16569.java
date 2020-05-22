class Details {
    @XmlElement(name="para")
    private Para para;
    ...
}

class Para {
    @XmlMixed
    @XmlAnyElement
    private List<Object> paragraphs;
    ...
}