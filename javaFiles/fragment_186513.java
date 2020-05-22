@Entity
@Table(name = "LABOUR_NO_PK")
public class LabourNoPK implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "labour_id")
    @NaturalId
    private Long labourId;

    @Column(name = "firstname")
    private String firstName;

    @OneToMany(mappedBy="labour")
    private Set<LabourNoPK> subordinates = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "contractor_id", referencedColumnName = "labour_id")
    /* child (subordinate) contractor_id will be matched with parent (labour) labour_id*/
    private LabourNoPK labour;

}