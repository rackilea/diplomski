import java.util.Timer;
import java.util.TimerTask;
import net.sf.ehcache.CacheManager;

public class EhCacheExpiryTask {
    class ExpiryTask extends TimerTask{
        @Override
        public void run() {
            for (CacheManager manager : CacheManager.ALL_CACHE_MANAGERS) {
                for (String name : manager.getCacheNames()) {
                    //manager.getCache(name).getCacheConfiguration().setStatistics(true);
                    manager.getCache(name).evictExpiredElements();                 
                } 
            }        
        }
    }
    private Timer timer;
    private long period;
    private ExpiryTask expiryTask;
    public EhCacheExpiryTask(long period){
        this.period = period;
        this.timer = new Timer();
    } 
    public void stop(){
        timer.cancel();
    }
    public void start(){
        expiryTask = new ExpiryTask();      
        timer.schedule(expiryTask, 10000, period);
    }
}