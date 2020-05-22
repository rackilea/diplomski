@Entity
@Table(name = "cats")
public class Cat {

  private Long id;

  private String name;

  @Transient
  private JsonNode json;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return id;
  }

  @Column(name ="name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  // Getter and setter for name

  @Transient
  public JsonNode getJson() {
    return json;
  }

  public void setJson(JsonNode json) {
    this.json = json;
  }


  @Column(name ="jsonString")
  public String getJsonString() {
    return this.json.toString();
  }

  public void setJsonString(String jsonString) {
    // parse from String to JsonNode object
    ObjectMapper mapper = new ObjectMapper();
    try {
      this.json = mapper.readTree(jsonString);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}