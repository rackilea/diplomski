@XmlRootElement
public class Students implements Serializable{

    private static final long serialVersionUID = 1L;

    private List<Person> personList;

    @XmlElement
    public List<Person> getPersonList() {
        return personList;
    }

}