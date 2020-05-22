@Entity
@Table(name="product_description")
public class ProductDescription {

      @Embeddable
      public static class ProductDescriptionPK implements Serializable {

      private static final long serialVersionUID = 1L;

      @Column(name = "product_id")
      protected Long productId;

      @Column(name = "language_id")
      protected Long languageId;

      public ProductDescriptionPK() {
      }

      public ProductDescriptionPK(Long productId, Long languageId) {
        super();
        this.productId = productId;
        this.languageId = languageId;
     }

   }

   @EmbeddedId
   private ProductDescriptionPK id;

   private String description;

   @ManyToOne
   @JoinColumn(name="language_id", nullable=false, insertable=false, updatable=false)
   private Language language;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="product_id", nullable=false, insertable=false, updatable=false)
   private Product product;

  // Other fields + getters and setters
}