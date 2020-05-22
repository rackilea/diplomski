@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    // your UserRepository for your user
    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (null == user || ! user.getUsername().equals(username)) {
            throw new UsernameNotFoundException("No user present with username: " + username);
        } else {

            return new CustomUserDetails(user);
        }
    }
}