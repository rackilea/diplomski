import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private int eventId;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_description")
    private String eventDescription;

    @ManyToOne
    @JoinColumn(name = "category_i")
    private Category category;

    @Column(name = "is_trending_event")
    private Integer isTrendingEvent;

    @Column(name = "image_url")
    private String imageUrl;

    private Integer status;

    @Column(name = "created_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;

    @Column(name = "last_updated_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastUpdatedDate;

    ...

}