public class UserRepository implements User {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public boolean save(User user) {
        User u = userRepository.save(user);
        if(u == null) {
            return false;
        } else {
            return true;
        }
    }
}