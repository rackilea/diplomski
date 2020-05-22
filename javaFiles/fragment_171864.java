@Entity
    public class WebSocketUser {
        @Id@GeneratedValue
        private long id;
        private long userId;
        private long sessionId;

        //constructors, getters and setters
    }