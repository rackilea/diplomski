@Component
public class SampleBeanImpl implements SampleBean {

  @Async
  void doSomething() { … }
}


@Component
public class SampleBeanInititalizer {

  @Autowired
  private final SampleBean bean;

  @PostConstruct
  public void initialize() {
    bean.doSomething();
  }
}