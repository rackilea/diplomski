@Entity
@Table(name="auto")
public class Make {
  ...

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "make")
  @JsonIgnoreProperties(value = "make") // to ignore the make from Model class while parsing to your json/xml
  private List<Model> models = new ArrayList<Model>(0);

  ...
}