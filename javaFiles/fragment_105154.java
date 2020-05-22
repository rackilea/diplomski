@Configurable
public class UserDomain {

    private Long id;

    private Date createdDate;

    private Date updatedDate;

    private String username;

    private String password;

    @Value("${default.user.enabled:true}")
    private Boolean enabled;

    ...
}