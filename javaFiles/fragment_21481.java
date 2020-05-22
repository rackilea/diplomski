@Component
public class MySpringBean implements InitializingBean {


    @Override
    public void afterPropertiesSet()
            throws Exception {
       //do your stuff
    }
}