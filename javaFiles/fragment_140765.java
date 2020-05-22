public class EmailAlert implements Serializable {
   @Id
   private Long id;

   @Column(name = "recipient")
   private String recipient;

   @Transient
   private transient String caption;

   // Constructor, Getters/Setters, etc
}