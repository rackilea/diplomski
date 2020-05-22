public class SandpitApplication extends Application {
  private static final long serialVersionUID = 1L;
  private static final Logger log = Logger.getLogger(SandpitApplication.class);

  // https://vaadin.com/wiki/-/wiki/Main/Spring%20Integration#section-Spring+Integration-SpringContextHelperClass
  private SpringContextHelper ctx;

  @Override
  public void init() {
    // vaadin stuff
    setTheme("common");
    final Window mainWindow = new Window("Vaadin Sample Application");
    setMainWindow(mainWindow);

    // get your bean from spring
    log.info("start SandpitApplication@" + Integer.toHexString(hashCode()));
    ctx = new SpringContextHelper(this);
    // create application-wide bean
    final MainController mainController = ctx.getBean("mainController");

    mainWindow.addComponent(new Button("click to post", new Button.ClickListener() {
      @Override public void buttonClick(final ClickEvent event) {
        log.info("click on button");
        EventBusFactory.getEventBusInstance().post(
            new FacetAddedEventImpl("click-"
                + new SimpleDateFormat("HH:mm:ss").format(new Date())));
        log.info(mainController);
      }
    }));
  }
}