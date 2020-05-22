@Service
public class MyClass{
  private final HttpClient httpClient;

  @Autowired
  public MyClass(HttpClient httpClient){
    this.httpClient = httpClient;
  }
}