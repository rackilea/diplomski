@Component
public class YourBean {
    @Value( "${db.user}" )
    private String dbUser;

    @Value( "${db.password}" )
    private String dbPassword;
}