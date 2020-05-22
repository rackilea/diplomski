public class TimerClassExample {
   public static void scheduleTaskOfDownload(Date SchedulerStartTime,Long SchedulerInterval) {
   // creating timer task, timer
   TimerTask tasknew = new MyFileDownloader (serverName);
   Timer timer = new Timer();

   // scheduling the task at interval
   timer.schedule(tasknew,SchedulerStartTime, SchedulerInterval);      
   }

}