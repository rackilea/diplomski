public interface IInput {}
public interface IOutput {}

public interface IExecutor<I extends IInput, O extends IOutput> {
  O execute(I i);
}

public class AbstractExecutor<I extends IInput, O extends IOutput>
       implements IExecutor<I, O> {
  private final I input;
  private final O output;

  protected AbstractExecutor(I input, O output) {
    this.input = input;
    this.output = output;
  }

  public O execute(I i) {
    ...
  }
}

@Component
public class UserInput implements IInput {}
@Component
public class UserOutput implements IOutput {}
@Repository
public class UserExecutor extends AbstractExecutor<UserInput, UserOutput> {
  @Autowired
  public UserExecutor(UserInput input, UserOutput output) {
    super(input, output);
  }
}

public interface IUserService {
  UserOutput execute(UserInput input, UserOutput output);
}

@Service
public UserService implements IUserService {
  private final UserExecutor executor;

  @Autowired
  public UserService(UserExecutor executor) {
    this.executor = executor;
  }

  public UserOutput execute(UserInput input) {
    return executor.execute(input);
  }
}