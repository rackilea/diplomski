@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User addEntity(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword());
        return userRepository.save(user);
    }

   ...

    public boolean isPassword(Object password, Long id) {
        User user = userRepository.findOne(id);
        String stringPassword = (String)((Map)password).get("password");
        return passwordEncoder.matches(stringPassword, user.getPassword());
    }

    public boolean updatePassword(Object passwords, Long id) {
        User user = userRepository.findOne(id);
        String oldPassword = (String)((Map)passwords).get("oldPassword");
        String newPassword = (String)((Map)passwords).get("newPassword");

        if (!passwordEncoder.matches(oldPassword, newPassword)) {
             return false;
        }
            user.setPassword(passwordEncoder.encode(newPassword));
            updateEntity(user);
            return true;

    }

    ...
}