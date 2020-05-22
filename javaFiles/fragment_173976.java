@Entity
@Table(name = "projects")
public class Project {

    @Id
    @Column(name = "project_name")
    private String projectName;

    private String description;

    @OneToMany(mappedBy = "project")
    private List<History> historyList;

    // getters and setters
    ...
}

@Entity
@Table(name = "histories")
public class History {

    @Id
    @Column(name = "history_id")
    private Integer historyId;

    @Temporal(TemporalType.DATE) // or TemporalType.TIMESTAMP
    private Date date;

    private String description;

    @ManyToOne
    @JoinColumn(name = "project_name")
    private Project project;

    // getters and setters
    ...
}