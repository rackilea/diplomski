public class SchedulerFactoryBeanWithWait extends SchedulerFactoryBean {

@Override
public void destroy() throws SchedulerException {
    super.destroy();
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        logError(e);
    }
 }
}