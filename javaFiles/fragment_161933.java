@Entity
public class License {    
    @Id @GeneratedValue private Integer id;
    private String licenseName;
    // add your fields here.
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    private String issueState;
}