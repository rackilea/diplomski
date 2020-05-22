public class Saying {
    private final long id;

    @Length(max = 3)
    private final String content;

    @JsonCreator
    public Saying(@JsonProperty("id") long id, @JsonProperty("content") String content) {//Note the addition of the ("id") and ("content") 
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}