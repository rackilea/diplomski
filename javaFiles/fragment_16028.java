public class Id {
  @JsonProperty String id;

  @JsonCreator
  public Id(String id) {
      this.id = id;
  }
}