@Component    
public class ApplicationStartup implements   ApplicationListener<ContextRefreshedEvent> {
    private static boolean fired = false;    
    @Override    
    public void onApplicationEvent(final ContextRefreshedEvent event) {    
        if (!fired) {
        //Your db inserts go there    
        System.out.println("Something simple like that, could do the job i think.");    
        fired = true;    
        }    
    }    
}