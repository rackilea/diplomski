@Entity
public class Sequence implements Serializable {

    @Id
    private Integer id;
    private String reference;

    @OneToMany(mappedBy="sequence")
    private List<ProjectSequence> projectSequenceList = new ArrayList<ProjectSequence>();

    @Transient
    private List<Project> projectList = null;

    // getters and setters

    public void addProject(Project project) {
        projectSequenceList.add(new ProjectSequence(new ProjectSequence.ProjectSequenceId(project.getId(), reference)));
    }

    public List<Project> getProjectList() {
        if(projectList != null)
            return projectList;

        projectList = new ArrayList<Project>();
        for (ProjectSequence projectSequence : projectSequenceList)
            projectList.add(projectSequence.getProject());

        return projectList;
    }

}