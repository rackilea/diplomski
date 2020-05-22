public class User {
  private Group group;
  private String name;
}

public class Group {
  private String id;
  private String name;

  @JsonCreator
  public static valueOf(String id) {return new Group(id);}

}