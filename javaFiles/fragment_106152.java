@Startup
@Singleton
public class RunMe{
  private static final Logger LOGGER = Logger.getLogger(RunMe.class.getName());


  @Inject
  MessageDTO messageDTO;


  @PostConstruct
  public void onStartup() {
    System.out.println("Initialization success.");
  }

  @Schedule(second = "*/10", minute = "*", hour = "*", persistent = false)
  public void run() throws Exception{
    //You can also substitute this method with constructor of the class -- removing the @Schedule annotation.
    int i = 0;
    while (true) {
      Thread.sleep(1000L);
      messageDTO.setText(UUID.randomUUID().toString().toUpperCase());
      i++;
      LOGGER.log(Level.INFO, "i : " + i);
    }
  }
}