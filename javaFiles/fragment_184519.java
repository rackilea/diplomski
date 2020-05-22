@Entity
@Table(name = "Ordr")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "creation", columnDefinition="TIMESTAMP(6)")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creation;

    // getters and setters
}