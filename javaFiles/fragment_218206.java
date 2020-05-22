ObjectMapper mapper = new ObjectMapper();
    System.out.println(mapper.writeValueAsString(new Something("Name", 12, "male", new Nested("books", "Music", "Movie"))));

public class Something {

    @JsonProperty("name")
    public String name;
    @JsonProperty("age")
    public int age;
    @JsonProperty("gender")
    public String gender;
    @JsonProperty("interest")
    public Nested nested;
    //Constructor
}

public class Nested {

    @JsonProperty("books")
    public String books;
    @JsonProperty("music")
    public String music;
    @JsonProperty("movie")
    public String movie;

    //Constructor
}