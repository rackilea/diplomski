@Component 
@ConditionalOnProperty( name = "my.cron.prop" )
public class Tasks {

    @Scheduled(cron = "${my.cron.prop}")
    public void task() {
       /*do your suff*/
    }