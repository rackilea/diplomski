@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private UserProfileJPARepository profileJPARepository;
    @Autowired
    private UserProfileContainer profileContainer;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = (User) userJpaRepository.findByLogin(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().name());
        UserDetails userDetails = (UserDetails) new SecureUser(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getMobileNumber(),
                user.getLogin(),
                user.getPassword(),
                user.isActive(),
                true,
                true,
                true,
                Arrays.asList(authority)
        );
        user.setLastLogonTime(new Timestamp((new Date()).getTime()));
        userJpaRepository.saveAndFlush(user);
        profileContainer.setUser(user);
        return userDetails;
    }

}