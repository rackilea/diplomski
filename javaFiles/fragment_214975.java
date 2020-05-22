public class Book{
  @JsonProperty("Title")
  @JsonSerialize(using = IgnoreSerializer.class)
  private String title;

  @JsonProperty("Author")
  @JsonSerialize(using = IgnoreSerializer.class)
  private String author;

  public setters & Getters
  ....
}