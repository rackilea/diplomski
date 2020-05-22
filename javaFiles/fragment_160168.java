@Component
@ManagedBean
@SessionScoped
public class UserErpMB {

private static final String SUCCESS = "success";
private static final String ERROR   = "error";

//Spring UserErp Service is injected...
@Autowired
private IUserErpService iUserErpService ; // getter and setter for this.

List<UserErp> usersList;
private int id;
private String name;
private String surname;