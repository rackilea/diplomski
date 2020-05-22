@Component
public class UserInfoServiceImpl implements UserInfoService {

@Autowired
private UserInfoRepository userInfoRepository;

public UserInfo register(UserRegisterRequest request) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<UserRegisterRequest> violations = validator.validate(input);
    if (!violations.isEmpty()) {
        // Do something on invalid input;
    }
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