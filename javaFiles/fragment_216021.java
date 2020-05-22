@Entity
public class FeedOrderDetail {

     @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
     private Long id;
     private double unitPrice;
     private long quantity;

     @ManyToOne(cascade=CascadeType.MERGE)
     @JoinColumn(name="feed_id")
     private Feed feed; // only a single feed reference

     //Getters and Setters
}