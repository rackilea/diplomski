@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        BlogUser user = userRepository.findByUserName(username)
                .orElseThrow(NotPresentedInDbException::new);

        return buildUserForAuthentication(user);
    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(BlogUser user) {

        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole().name());
        List<GrantedAuthority> authorities = Lists.newArrayList(grantedAuthority);

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                user.isEnabled(),
                true,
                true,
                true,
                authorities);
    }
}