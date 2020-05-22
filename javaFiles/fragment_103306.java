public class UserDto {

  private String firstname;
  private String lastname;
  private ZonedDateTime createdProfileFrom;
  private ZonedDateTime createdProfileTo;

  @JsonProperty("createdProfile")
  private void unpackNested(Map<String,Object> elements) {
    this.createdProfileFrom = ZonedDateTime.parse((String)elements.get("from"), DateTimeFormatter.ISO_DATE_TIME);
    this.createdProfileTo = ZonedDateTime.parse((String)elements.get("to"), DateTimeFormatter.ISO_DATE_TIME);
  }

   //getters + setters
}