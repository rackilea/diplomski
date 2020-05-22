@Entity
public class Program{
    @Id
    private String programId;

    @OneToMany(mappedBy="program", cascade=CascadeType.ALL)
    List<Product> products;
}

@Entity
public class Product {

    @Id
    private String productId;

    @ManyToOne
    @JoinColumn(name="programId")
    private Program program;
}