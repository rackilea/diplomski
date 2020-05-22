@Aspect
public class SystemStateRestInterceptor {
  @Autowired
  private SystemStateWebSocketBuffer systemStateWebSocketBuffer;

  @Before("execution(* org.company.MyRestService.processTablesClearQuery(..))")
  public void interceptConfigStartEvent() {
    systemStateWebSocketBuffer.getSystemStateSockets()
                              .forEach(socket -> socket.onConfigurationStart());
  }

}