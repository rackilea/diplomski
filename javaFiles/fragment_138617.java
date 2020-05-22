@JsonSerialize(using = PersonSerializer.class)
public class Person
{
    private Long id;
    private String name;
    //Rest of the getters and setters

}