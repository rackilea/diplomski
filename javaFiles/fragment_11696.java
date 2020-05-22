@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) //can use in field only.
public @interface JsonName
{   
    String value();
}


@JsonSerialize(using = DTOSerializer.class)
public class DTO
{
    @JsonName("individual.lastName")
    public List<String> lastName = Arrays.asList("LastName1", "LastName2");
    @JsonName("individual.firstName")
    public List<String> firstName = Arrays.asList("firstName1");
}