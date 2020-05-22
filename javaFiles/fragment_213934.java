@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    //get user from the database, via Hibernate
    @Autowired
    private UserDao userDao;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(final String username)
        throws UsernameNotFoundException {
//CUSTOM USER HERE vvv
        User user = userDao.findByUserName(username);
        List<GrantedAuthority> authorities =
                                      buildUserAuthority(user.getUserRole());
//if you're implementing UserDetails you wouldn't need to call this method and instead return the User as it is
        //return buildUserForAuthentication(user, authorities);
return user;

    }

    // Converts user to spring.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(user,
        List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(),
            user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // add user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

}