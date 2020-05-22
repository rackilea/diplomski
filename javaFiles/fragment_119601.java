@Data
public class FullAddress {

    private String address;

    @JsonDeserialize(using = RawJsonDeserializer.class)
    private String contactInfo;
}