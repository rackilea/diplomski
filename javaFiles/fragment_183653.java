@Entity
@Table(name = "main_order")
public class MainOrder {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "file_dir")
    private String fileDir;
    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // generate getter and setter here 
}