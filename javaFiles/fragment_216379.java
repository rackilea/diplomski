@Component
public class InitClass{

  private UsarioService usarioService;

  @Autowired
  public InitClass(UsarioService usarioService){
    this.usarioService = usarioService;
  }         

  @PostConstruct
  public void init(){
    new LoginView(usarioService);
  }         
}