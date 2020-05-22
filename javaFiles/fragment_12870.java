private YourClass self;

@Autowired
private ApplicationContext applicationContext;

@PostConstruct
public void postContruct(){
    self = applicationContext.getBean(YourClass.class);
}