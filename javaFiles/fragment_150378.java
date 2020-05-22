@Service
public class UserServiceImpl implements UserService {
@Resource
    UserDao userRepository;
@Override
    public User findOne(Long id) {

        User user = userRepository.findOne(id);
        return user;
    }