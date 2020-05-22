@XmlElements({ 
    @XmlElement(name="girl", type=Girl.class),
    @XmlElement(name="boy", type=Boy.class)
})
@XmlElementWrapper
public List<Person> getPeople() {
    return people;
}