@JacksonXmlRootElement(localName = "jokes")
class Jokes {

    @JacksonXmlProperty(localName = "joke")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Joke[] jokes;

    // getter, setter omitted
}

class Joke {
    @JacksonXmlProperty(isAttribute = true)
    long id;

    @JacksonXmlProperty(localName = "title")
    String title;

    @JsonIgnore
    String author;

    @JacksonXmlProperty(localName = "like")
    long like;

    @JsonIgnore
    String content;

    public String toString() {
        return Arrays.stream(new Object[] {id, title, author, like, content})
                .map(o -> o!=null ? o.toString() : "EMPTY")
                .collect(Collectors.joining(", ", "[", "]"));
    }

    // getters, setters omitted
}