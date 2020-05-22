@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({@JsonSubTypes.Type(value = Text.class, name = "text"), @JsonSubTypes.Type(value = Image.class, name = "image")
})
public abstract class BaseClass {
    public String type;
    public String subType;
}