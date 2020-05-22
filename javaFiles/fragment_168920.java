@Entity
 @Table(name = "chatMessages")
 @Data
 public class Message {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long id;

      private String fromV;
      private String messageV;
      private Timestamp sendTime;