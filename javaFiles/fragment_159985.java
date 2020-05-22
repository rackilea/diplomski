@Entity
public class Project implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(mappedBy="project")
    private List<ProjectSequence> projectSequenceList = new ArrayList<ProjectSequence>();

    @Transient
    private List<Sequence> sequenceList = null;

    // getters and setters

    public void addSequence(Sequence sequence) {
        projectSequenceList.add(new ProjectSequence(new ProjectSequence.ProjectSequenceId(id, sequence.getReference())));
    }

    public List<Sequence> getSequenceList() {
        if(sequenceList != null)
            return sequenceList;

        sequenceList = new ArrayList<Sequence>();
        for (ProjectSequence projectSequence : projectSequenceList)
            sequenceList.add(projectSequence.getSequence());

        return sequenceList;
    }

}