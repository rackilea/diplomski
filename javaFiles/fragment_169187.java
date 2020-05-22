@Entity 
public class Product{
   @Id
   private Long id;
   private String name;
   @OneToMany(mappedBy = "product")
   private Set<ProductAisle> productAisle = new HashSet<>;
   /* getters, setters, equals and hashcode */
}


@Entity 
public class Aisle{
   @Id
   private Long id;
   private String row;
   private String shelf;
   @OneToMany(mappedBy = "aisle")
   private Set<ProductAisle> productAisle = new HashSet<>();
   /* getters, setters, equals and hashcode */
}

@Entity 
public class ProductAisle{
   @Id
   private Long id;
   @ManyToOne(fetch = FetchType.LAZY)
   private Product product;
   @ManyToOne(fetch = FetchType.LAZY)
   private Aisle aisle;
   /* getters, setters, equals and hashcode */
}