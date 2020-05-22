@XmlRootElement(name="User")
public class User{

    private int id;
    private String name; 

    public User() {

    }


    @XmlElement
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }  
}