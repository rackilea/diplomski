@Autowired
private ImportTimerTask importTimerTask;

@PostConstruct
@Transactional
public void importData() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 9);
    calendar.set(Calendar.MINUTE, 2);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    Timer time = new Timer();
    time.schedule(importTimerTask, calendar.getTime(),
            TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
}