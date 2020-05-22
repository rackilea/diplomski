@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "customer_id",updatable = false, nullable = false)
    private Long custId;

    private String name;
    private String email;
    private String gender;

    @ManyToOne
    private Product product;
}