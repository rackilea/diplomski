@XmlRootElement(name = "userinfo")
public class UserInfo {
    @XmlElement
    public List<Long> values;
    // JAXB really requires a no-argument constructor...
    public UserInfo() {}
    // Convenience constructor to make the code cleaner...
    public UserInfo(List<Long> theList) {
        values = theList;
    }
}