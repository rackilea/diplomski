public class SessionAndUser {

    @Embedded
    private Session session;

    @Relation(parentColumn = "user_id", entityColumn = "user_id")
    private User user;
}