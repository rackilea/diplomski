/**
 * Created by roman.luo on 2016/9/14.
 */
@Component
@Scope("prototype")
public class JobDelegate implements Job {

    private Job job;

    public JobDelegate(Job job) {
        this.job = job;
    }

    @Async
    public void run(){
        job.run();
    }
}

/**
 * Created by roman.luo on 2016/9/14.
 */
@Component
public class Sceduled extends ApplicationObjectSupport{

    @Scheduled(fixedRate = 100)
    public void run(){
        Job job = QUEUE.take();
        Job jobDelegate = getApplicationContext().getBean(JobDelegate.class,job);
        jobDelegate.run();
    }

}