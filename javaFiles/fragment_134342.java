@Component
@Lazy
public class Resource implements ApplicationContextAware{

    private ApplicationContext applicationContext;

    @PostConstruct
    public void post(){
        applicationContext.getBeansOfType(CustomProcessor.class);
    }

    public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
        this.applicationContext = applicationContext;   
    }

}