@Component
public final class Startup {

  private static final long serialVersionUID = 6465240550145652729L;

  @EJB(name="MyStartupBean")
  private MyBeanLocal bean;

  @PostConstruct
  public void init() {
    bean.start();
  }

  @PreDestroy
  public void destroy() {
    bean.stop();
  }
}