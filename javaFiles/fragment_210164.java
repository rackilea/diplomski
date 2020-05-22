@Entity
@Table (name="client")
@SequenceGenerator(name="sequence1",sequenceName="BIM***********.SEQUENCE1",
allocationSize=1, initialValue=1)
public class Client {

    //Fields
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence1")
    @Column(name="CLIENT_ID")
    private String id;