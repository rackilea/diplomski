@XmlRootElement
public class UserInfoFlattened
{
    @XmlElement
    private int id;

    @XmlElement
    private String name;

    @XmlElement ( name = "value" )
    private boolean allowed;
}