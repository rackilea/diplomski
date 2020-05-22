@Service
public class UserService {
    private final String svnUrl;

    @Autowired
    public UserService(@Value("${SVN_URL}") String svnUrl) {
        this.svnUrl = svnUrl;
    }
}