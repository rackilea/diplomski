@Repository("userExecutor")
public class UserExecutor extends AbstractExecutor {
  @Autowired
  public UserExecutor(@Qualifier("userInput") UserInput input
    , @Qualifier("userOutput") UserOutput output) { super(input, output); }
}