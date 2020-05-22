@XmlRootElement
public class Account {
    @XmlAttribute
    public Long id;
    public String name;

    @XmlElementWrapper(name = "friends")
    @XmlElement(name = "friend")
    @XmlJavaTypeAdapter( value = AccountAdapter.class )
    public List<Account> friends;
}