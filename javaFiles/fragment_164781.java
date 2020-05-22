public interface Mapping {
    public final static String USERS = "users";
    public final static String PERMISSIONS = "permissions";
}

@RequestMapping(Mapping.USERS)
public UserController {
   ............
}