@XmlRootElement
public class Data{

    public Set<Tag> tags;
}

public class Tag{

    @XmlAttribute
    public Integer id;

    @JsonValue
    public Integer getId() {
        return id;
    }
}