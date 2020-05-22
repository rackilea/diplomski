@Table(name="report")
public class Report implements Serializable {

  @EmbeddedId
  protected ReportPK id;
...