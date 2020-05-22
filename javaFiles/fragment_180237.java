import org.quartz.Scheduler;
  import org.quartz.SchedulerException;
  import org.quartz.impl.StdSchedulerFactory;
  import static org.quartz.JobBuilder.*;
  import static org.quartz.TriggerBuilder.*;
  import static org.quartz.SimpleScheduleBuilder.*;

  public class QuartzTest {

      public static void main(String[] args) {

          try {
              Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

              scheduler.start();

              scheduler.shutdown();  //take out this line

          } catch (SchedulerException se) {
              se.printStackTrace();
          }
      }
  }