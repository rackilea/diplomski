@Entity
public class Feed {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private long quantity;
    //With getters and setters

    // !new!
    @OneToMany(mappedBy = "feed") // mappedBy references the fieldname in the other Java class
    private List<FeedOrderDetail> details;
}