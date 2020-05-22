@Service
public class ServerLoggingService() {

  @Autowired
  private ServletContext servletContext;

  @PostConstruct
  public void printServer() {
      System.out.println("Server Version: " + this.servletContext.getServerInfo());
  }
}