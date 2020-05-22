@Component
public class AdapterService{
    @Autowired
    private ApplicationContext applicationContext;

    public A getService(String name){
        return applicationContext.getBean(name,A.class);
    }
}