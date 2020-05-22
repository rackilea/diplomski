@Data
@Entity
@Table(name="project")
public class Project {

@Id
private Long idProject;
private String description;
private boolean isFinished;
private String startDate;
private String finishDate;
private String name;
}