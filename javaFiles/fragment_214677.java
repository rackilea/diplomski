@Entity
@Table(name = "job_record")
public class JobRecord {

    @Id
    @Column(name = "job_id")
    private Integer jobId;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private JobState state;

    @ElementCollection
    @CollectionTable(name="job_label",
           joinColumns=@JoinColumn(name="job_id")) 
    private List<JobLabelRecord> labels;
...

@Embeddable
public class JobLabelRecord {
    @Enumerated(EnumType.STRING)
    @Column(name = "label_key")
    private JobLabelKey key;

    @Column(name = "label")
    private String label;
...