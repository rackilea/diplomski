@Document(collection = "computers")
public class Computer {

  @Id
  private String id;

  @Field("name")
  private String name;

  //Other constant fields

  @Field("properties")
  private Map<String, Object> properties;

}