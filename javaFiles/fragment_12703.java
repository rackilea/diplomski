@JsonSerialize(using = PropertyValueSerializer.class)
@JsonDeserialize(using = PropertyValueDeserializer.class)
public class PROPERTY_VALUE implements Serializable{

    private String key;
    private String value;