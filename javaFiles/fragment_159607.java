@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "product_id",updatable = false, nullable = false)
    private Long pId;
    private String productName;
    private int pQty;
    private int price;

    @OneToMany
    private List<Customer> customerList;
}