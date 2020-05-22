@XmlRootElement(name = "ConsumerInfo")
public class DemoCustomer {


    private String firstName;

    private String lastName;


    @XmlElement(name= "FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(name = "LastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }