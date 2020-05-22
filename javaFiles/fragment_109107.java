final class PersonDto {
  private final String name; // name
  private final String city; // address.city

  public PersonDto(String name, String city) {
    this.name = name;
    this.city = city;
  }

  @JsonCreator
  public PersonDto(@JsonProperty("name") String name, @JsonProperty("address") Map<String, Object> address) {
    this(name, address.get("city"))
  }
}