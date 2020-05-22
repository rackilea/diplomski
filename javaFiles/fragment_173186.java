@Service
public class NotificationManager {

    @Autowired
    private TaskScheduler scheduler;

    private ScheduledFuture<?> sc;

    public void scheduleTask(WebSocketMessage webSocketMessage, String userName, Date date, Date time) {
        scheduleTask(webSocketMessage, userName, combine(date,time));
    }

    public void scheduleTask(WebSocketMessage webSocketMessage, String userName, Date startTime) 
    { 
        Runnable r = new NotificationSenderTask(webSocketMessage, userName);
        sc = scheduler.schedule(r, new Date());

   }
}