public class Database {
   private final ConnectionFactory connectionFactory;

   public Database(ConnectionFactory connectionFactory) {
      this.connectionFactory = connectionFactory;
   }

   // change to private and use the factory
   private Connection getConnection() {
      return connectionFactory.getConnection();
   }

   // example method to be used by servlet
   public int getTotalReservations(int typeRoom, String arrivalDate, departureDate) {
      // query related code currently in serlvet goes here...
   }
}