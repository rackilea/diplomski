import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @ManyToOne
    @JoinColumn(name="parent_category_id")
    private Category parentCategory;

    @Column(name = "created_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;

    @Column(name = "last_updated_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastUpdatedDate;

    @OneToMany(mappedBy="category")
    private List<Event> events;

    ...

}