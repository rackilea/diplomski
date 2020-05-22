@Component
@Validated
public class UserInfoServiceImpl implements UserInfoService {

@Autowired
private UserInfoRepository userInfoRepository;

public UserInfo register(@Valid UserRegisterRequest request) {

    UserInfo user = new UserInfo();
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setEmail(request.getEmail());
    user.setPhone(request.getPhone());
    // Password hashing
    user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
    user.setIsActive(0);
    user.setStatus(1);

    return userInfoRepository.save(user);
  }
}