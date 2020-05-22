@XmlRootElement(name="Helloworld")
@XmlType(propOrder = { "userName"})
public class UserDetails {
    //User Name
    private String userName;

    @XmlElement(name="UserName")   
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}