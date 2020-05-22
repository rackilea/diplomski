@XmlRootElement(name = "user")
@XmlType(propOrder = { "userName", "firstName", "lastName" })
public class User{

    private String userName;
    private String firstName;
    private String lastName;
    ....get/set