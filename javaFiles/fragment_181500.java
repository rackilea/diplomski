public class SingletonClient{

    @Autowired
    private Singleton singleton;

    public void foo(){
        singleton.getInstance().method();
    } 
}