public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService delegate;

    public UserDetailsServiceAdapter(UserService delegate) {
        this.delegate=delegate;
    }

    public UserDetails loadUserByUsername(String username) {
       reutrn userService.findByUsername(name)
                 .map(this::toUserDetails).orElseThrow(() -> new UsernameNotFoundException("Unknown user " + username);
    }

    private UserDetails toUserDetails(User user) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(r -> authorities.add(new SimpleGrantedAuthority(r));
         return new UserDetails(user.getUsername(), user.getPassword(), authorities);
    }
}