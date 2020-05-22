@Entity 
public class Salesman{
   @Id
   private Long id;

   private String name;

   @ManyToOne(fetch = FetchType.LAZY)
   private Set<ProductAisle> productAisle;

}