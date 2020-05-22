public class POJO {
  @JsonCreator
  public POJO(@JsonProperty(value="name", required=true) String name,
       @JsonProperty(value="age", required=true) int age) {
    ...
  }