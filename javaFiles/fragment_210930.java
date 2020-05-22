@Entity
@Table(name = "AW_MEDIA_DETAILS")
public class MediaDetails implements WFPayload , Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "REQUEST_ID", unique = true, nullable = false)
    Long requestId;
    ....