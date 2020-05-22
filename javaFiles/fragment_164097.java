public abstract class BaseEntity {

    protected Long id = null;
    protected String name;

public class User extends BaseEntity {
    private Date birthday;
    private String email;
    private String password;
    private String role;
    private boolean enabled;