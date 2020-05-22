@Entity
public class Session implements Serializable {

   ..
   @Temporal(TemporalType.TIMESTAMP)
   private Date timestamp;
   ..

   public Session(String sessionId) {
       this.sessionId = sessionId;
       this.timestamp = new Date();
   }

   public Session() {
       this.timestamp = new Date();
   }
}