@JsonCreator
public Name(@JsonProperty("givenName") String g, @JsonProperty("familyName") String f)
{
  givenName = g;
  familyName = f;
}