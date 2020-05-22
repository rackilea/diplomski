package packagename...;

    import java.io.File;
    import org.quartz.Scheduler;
    import org.quartz.SchedulerException;
    import org.quartz.SchedulerFactory;
    import org.quartz.impl.StdSchedulerFactory;


    public class ScheduleServer {

        public ScheduleServer() {
            // TODO Auto-generated constructor stub
        }

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            try {


                SchedulerFactory sf = new StdSchedulerFactory();
                Scheduler sch = sf.getScheduler();
                sch.start();

            } catch (SchedulerException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }