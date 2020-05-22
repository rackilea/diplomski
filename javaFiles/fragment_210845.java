@Embeddable
public class ReportPK implements Serializable {

  @Basic(optional = false)
  @Column(name="id")
  private int id;
  @Basic(optional = false)
  @Column(name="index")
  private String index;
...