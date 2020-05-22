@Autowired
ThreadPoolTaskScheduler scheduler;

@PostMapping(value = "/wake-me-up", consumes = "application/json")
@ResponseStatus(HttpStatus.OK)
public void scheduleCall(@RequestBody WakeMeUpRequest request) {
    scheduler.schedule(
            new WakeUpCallTask(request.getParameter1(), request.getParameter2()),
            new Date(System.currentTimeMillis() + 10000));
}