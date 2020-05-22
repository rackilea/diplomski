import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Timer;
import javax.ejb.Stateless;
import javax.ejb.Timeout;

@Stateless
public class TimerSessionBean implements TimerSessionBeanRemote {

    @Resource
    private SessionContext context;

    public void createTimer(long duration) {
    context.getTimerService().createTimer(duration, "Hello World!");
    }

    @Timeout
    public void timeOutHandler(Timer timer){
    System.out.println("timeoutHandler : " + timer.getInfo());        
    timer.cancel();
    }
}