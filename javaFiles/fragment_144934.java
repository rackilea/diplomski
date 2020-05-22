@JsonSerialize(using = CustomJsonPropertySerializer.class)
public class Bar {

    @CustomJsonProperty.List({
        @CustomJsonProperty(propertyName = "first-name", format = "A"),
        @CustomJsonProperty(propertyName = "firstName", format = "B")
    })
    private String firstName;

    @CustomJsonProperty.List({
            @CustomJsonProperty(propertyName = "last-name", format = "A"),
            @CustomJsonProperty(propertyName = "lastName", format = "B")
    })
    private String lastName;

    @CustomJsonProperty.List({
            @CustomJsonProperty(propertyName = "gender-x", format = "A"),
            @CustomJsonProperty(propertyName = "gender", format = "B")
    })
    private String gender;

    @JsonIgnore
    private String format;

    //getters & setters

}