@Service
@Transactional
public class LoginService {

    @Autowired
    private userDAO userManagement;

    public void insertUser(users userToAdd) {
        this.userManagement.insertUser(userToAdd);
    }
}