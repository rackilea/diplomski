@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Persons", propOrder = {
    "person"
})
@XmlRootElement(name = "Persons")
public class Persons
    implements Serializable
{

    private final static long serialVersionUID = 12343L;
    @XmlElement(name = "Person", required = true)
    protected List<Person> person;

    // getter and setter

}