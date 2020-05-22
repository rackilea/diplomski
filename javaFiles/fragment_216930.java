@Entity
@Table(name = "PROJECTS")
public class Project {
@Column(name = "SL_NO" , insertable = false, updatable = false)
private Integer SlNo;
@Column(name = "PROJECT_NO" , insertable = false, updatable = false)
private Long projectNo;
private Date projectDate;

@EmbeddedId
ProjectPK projectPK;