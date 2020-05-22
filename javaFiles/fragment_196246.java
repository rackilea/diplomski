import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

    import org.quartz.SchedulerFactory;
    import org.quartz.Trigger;


    /**
     * Hello world!
     *
     */
    public class App 
    {

        public static void main( String[] args )
        {
             SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

              Scheduler sched;
            try {
                sched = schedFact.getScheduler();

                Properties props = new Properties();
                InputStream inputStream = sched.getClass().getClassLoader()
                        .getResourceAsStream("test.properties");

                props.load(inputStream);

                String cronString = props.getProperty("cron");

                  // define the job and tie it to our HelloJob class
                  JobDetail job = JobBuilder.newJob(HelloJob.class)
                      .withIdentity("myJob", "group1")
                      .build();

                System.out.println( "Hello World!" );
                Trigger trigger = newTrigger()
                        .withIdentity("trigger3", "group1")
                        .withSchedule(cronSchedule(cronString))
                        .forJob("myJob", "group1")
                        .build();

                sched.scheduleJob(job,trigger);
                sched.start();
            } catch (SchedulerException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }

    }