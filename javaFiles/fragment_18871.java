@Service
public class UserNumServiceImpl implements UserNumService {

  @Autowired
  private UserNumRepository userNumRepository;

  @Override
  public long getNext() {
    UserNum last = userNumRepository.findTopByOrderByIdDesc();
    long lastNum = last.seq;
    UserNum next = new UserNum(lastNum + 1);
    userNumRepository.save(next);
    return next.seq;
  }
}