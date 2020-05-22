@XmlRootElement
public class Students implements Serializable{

    private static final long serialVersionUID = 1L;

    private List<Person> person = new ArrayList<Person>();

    public List<Person> getPersonList() {
        return person;
    }

    public void setPersonList(List<Person> personList) {
        this.person = personList;
    }

}