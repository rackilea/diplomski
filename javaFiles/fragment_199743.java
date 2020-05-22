@JsonFilter("firstFilter")
public class MyDtoWithFilter {

    private String name;

    private String anotherName;
    private SecondDtoWithFilter dtoWith;

    // get set ....
}
 @JsonFilter("secondFilter")
public class SecondDtoWithFilter{
    private long id;
    private String secondName;
}