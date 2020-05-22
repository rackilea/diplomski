@Component
public class X implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
       //do something if all apps have initialised
    }
}