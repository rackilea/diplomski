@Entity
   @Table(schema = "SCHEMA", name = "TABLE")
   public class CompositeIdEntity {

   @EmbeddedId
   CompositePrimaryKeyTableEmbeddable id;

   @Column(name = "NAME3")
   private String name3;