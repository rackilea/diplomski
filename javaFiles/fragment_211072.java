@Component
@Profile("dev")
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("User");
        user.setEmail("email@google.com");
        user.setUserName("admin");
        user.setPassword(passwordEncoder.encode("PASSWORD"));
        userRepository.save(user);
    }
}