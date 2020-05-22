@XmlRootElement(name = "content")
public class Content {

    @XmlElement(required = true)
    protected List<Object> person;
    @XmlElement(required = true)
    protected List<Object> group;

    public List<Object> getPerson() {
        if (person == null) {
            person = new ArrayList<Object>();
        }
        return this.person;
    }

    public List<Object> getGroup() {
        if (group == null) {
            group = new ArrayList<Object>();
        }
        return this.group;
    }
}