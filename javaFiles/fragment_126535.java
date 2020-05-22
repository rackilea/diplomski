@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String username)
                        throws UsernameNotFoundException {
        User user = userService.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);   
        }

        return org.springframework.security.core.userdetails.User(username, user.getPassword(), user.isActivated(), true, true, true, user.getRoles().stream().map(role -> role.getRoleName()).map(SimpleGrantedAuthority::new).collect(Collectors.toList()));

    }
}