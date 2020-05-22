@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if (userRepo.count() < 1) {
            System.out.println("SpringUser not found! " + userName);
            throw new UsernameNotFoundException("SpringUser " + userName + " was not found in the database");
        }
        return userRepo.findAll().iterator().next();
    }
}