@Implementation(PersonImpl.class)
public interface Person extends Entity {

  String getLastName();
  void setLastName(String name);

  String getFirstName();
  void setFirstName(String name);

  @Ignore
  String getName();
}