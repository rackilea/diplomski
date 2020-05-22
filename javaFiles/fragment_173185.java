public class NotificationManager {
    @Autowired
    private TaskScheduler scheduler;

    public NotificationManager(WebSocketMessage webSocketMessage, String userName, Date date, Date time) {
        AutowireHelper.autowire(this, scheduler);
        scheduleTask(webSocketMessage, userName, combine(date,time));
    }
    ...
}