@Service
public class MyCustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MyCustomUserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.getByUsername(username);
    }
}