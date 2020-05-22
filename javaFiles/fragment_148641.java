@Component
public class JustAClass{
  private static Service service;

  @Autowired
  private Service tmpService;

  @PostConstruct
  public void init() {
    service = tmpService;
  }

}