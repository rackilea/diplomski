@Component
@ConditionalOnProperty(prefix = "spring.cron", name = "expression")
public class MyScheduler {
   @Scheduled(cron = "${spring.cron.expression}")
   public void demonJob() throws .. { .. }
}