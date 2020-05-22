@SuppressWarnings("restriction")
public class ContextConfiguration implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        //refresh awt context
        if(AppContext.getAppContext() == null) {
            SunToolkit.createNewAppContext();
        }
    }
}