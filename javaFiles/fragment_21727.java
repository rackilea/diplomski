@Service
public class UserDetailsServiceImpl implements UserDetailsService {

private final UserRepository repository;

@Autowired
public UserDetailsServiceImpl(UserRepository repository) {
    this.repository = repository;
}

@Override
public UserDetails loadUserByUsername(String alias) {
    User user = repository.findByAlias(alias);
    if (user == null) {
        //Do something about it :) AFAIK this method must not return null in any case, so an un-/ checked exception might be a good option
        throw new RuntimeException(String.format("User, identified by '%s', not found", alias));
    }
    return new org.springframework.security.core.userdetails.User(
                           user.getAlias(), user.getPassword(),
                           AuthorityUtils.createAuthorityList(user.getRole()));
  }
}