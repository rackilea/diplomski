@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SomeBean {

  private static final Logger log = LoggerFactory.getLogger(SomeBean.class);

  private final MyFactory factory;
  private final GenericApplicationContext context;

  @Autowired
  public SomeBean(GenericApplicationContext context, MyFactory factory) {
    this.context = context;
    this.factory = factory;
  }

  @PostConstruct
  public void init() {
    factory.getSupportedClasses().forEach(this::register);
  }

  private <T> void register(Class<T> clazz) {
    log.info("Registering {} as a bean into ApplicationContext", clazz);
    context.registerBean(clazz,
        () -> factory.getInstance(clazz),
        (beanDefinition -> beanDefinition.setScope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)));
  }
}