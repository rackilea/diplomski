@XmlElements(
    @XmlElement(name="Content", type=Content.class),
    @XmlElement(name="SpecialCharacter", type=SpecialCharacter.class)
})
public List<Object> getValues() {
    return values;
}